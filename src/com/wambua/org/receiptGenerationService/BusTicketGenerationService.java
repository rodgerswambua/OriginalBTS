/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wambua.org.receiptGenerationService;
import com.wambua.org.dao.DatabaseAccessObjects;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.wambua.org.dao.javaconnect;
import java.io.File;



import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Random;


/**
 *
 * @author ROJJAH
 */
public class BusTicketGenerationService {
    private static final Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font titleFontSmall = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
    private static final Font titleFontMedium = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static final Font tableColumnHeadersFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
    private static final Font tableCellFont = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL);
    private static final Font printedOnFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.ITALIC);
    
     public static void generateTicketDetailsPdf() {

        try {
            
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.showSaveDialog(null);

            File file = fileChooser.getSelectedFile();
           int documentSerialNumber = new Random(System.currentTimeMillis() + LocalTime.now().getSecond() + LocalTime.now().getMinute()).nextInt();
            String serialNumber = Integer.toString(documentSerialNumber).substring(0, 7);
            File fileObj = new File(file + "\\Ticket Details :" + DatabaseAccessObjects.getCompanyName() + LocalDate.now().getMonth()
                    + LocalDate.now().getYear() + "Serial Number"
                    + serialNumber + ".pdf");
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream(fileObj));

            document.open();

            Paragraph title = new Paragraph();
            title.setAlignment(Paragraph.ALIGN_CENTER);
            title.add(new Chunk(DatabaseAccessObjects.getCompanyName(), titleFont));
            title.add(Chunk.NEWLINE);
            title.add(new Chunk(DatabaseAccessObjects.getCompanyAddress().toUpperCase() + " ,TEL:"
                    + DatabaseAccessObjects.getCompanyTelephoneNumber() + ", EMAIL:"
                    + DatabaseAccessObjects.getCompanyEmailaddress(), titleFontSmall));
            title.add(Chunk.NEWLINE);
            title.add(new Chunk("CUSTOMERS' SEAT DETAILS", titleFontMedium));
            document.add(title);

            Paragraph tableParagraph = new Paragraph();
            tableParagraph.add(Chunk.NEWLINE);

            Paragraph monthParagraph = new Paragraph();
            monthParagraph.add(new Chunk("" + LocalDate.now().getMonth() + "   " + LocalDate.now().getYear(), titleFontSmall));
            monthParagraph.setAlignment(Paragraph.ALIGN_RIGHT);
            document.add(monthParagraph);

            PdfPTable TicketDetailsTable = new PdfPTable(7);

            TicketDetailsTable.setWidthPercentage(107);
            TicketDetailsTable.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPCell SeatNumberCell = new PdfPCell(new Phrase("Seat Number", tableColumnHeadersFont));
            PdfPCell lastNameCell = new PdfPCell(new Phrase("Last Name", tableColumnHeadersFont));
            PdfPCell ClientTelNoCell = new PdfPCell(new Phrase("Tel Number", tableColumnHeadersFont));
            PdfPCell BusNameCell = new PdfPCell(new Phrase("Bus Name", tableColumnHeadersFont));
            PdfPCell DepartureTimeCell = new PdfPCell(new Phrase("Departure Time", tableColumnHeadersFont));
            PdfPCell BusFareCell = new PdfPCell(new Phrase("Bus Fare", tableColumnHeadersFont));
            PdfPCell PickUpPointCell = new PdfPCell(new Phrase("Pickup Point", tableColumnHeadersFont));

            TicketDetailsTable.addCell(SeatNumberCell);
            TicketDetailsTable.addCell(lastNameCell);
            TicketDetailsTable.addCell(ClientTelNoCell);
            TicketDetailsTable.addCell(BusNameCell);
            TicketDetailsTable.addCell(DepartureTimeCell);
            TicketDetailsTable.addCell(BusFareCell);
            TicketDetailsTable.addCell(PickUpPointCell);

            try {
                 Connection conn = javaconnect.ConnectDb();
                 PreparedStatement preparedStatement = conn.prepareStatement("SELECT seatNo,last_name,Telephone,"
                        + "Bus_Name,Departure,Normal_fare,"
                        + "pickup FROM busd,`buses` WHERE buses.DOT = busd.TravelDate;");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    TicketDetailsTable.addCell(new PdfPCell(new Phrase(resultSet.getString(1), tableCellFont)));
                    TicketDetailsTable.addCell(new PdfPCell(new Phrase(resultSet.getString(2), tableCellFont)));
                    TicketDetailsTable.addCell(new PdfPCell(new Phrase(resultSet.getString(3), tableCellFont)));
                    TicketDetailsTable.addCell(new PdfPCell(new Phrase(resultSet.getString(4), tableCellFont)));
                    TicketDetailsTable.addCell(new PdfPCell(new Phrase(resultSet.getString(5), tableCellFont)));
                    TicketDetailsTable.addCell(new PdfPCell(new Phrase(resultSet.getString(6), tableCellFont)));
                    TicketDetailsTable.addCell(new PdfPCell(new Phrase(resultSet.getString(7), tableCellFont)));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            tableParagraph.add(TicketDetailsTable);

            tableParagraph.add(Chunk.NEWLINE);
            tableParagraph.add(Chunk.NEWLINE);

            Paragraph directorsSignParagraph = new Paragraph();
            directorsSignParagraph.add(Chunk.NEWLINE);
            directorsSignParagraph.add(Chunk.NEWLINE);
            directorsSignParagraph.add(new Chunk("Director: Name.....................................               "
                    + "Sign:...........................................                           ", tableColumnHeadersFont));
            directorsSignParagraph.add(new Chunk("Chief Accountant: Name .....................................       "
                    + "Sign:...........................................", tableColumnHeadersFont));
            directorsSignParagraph.add(Chunk.NEWLINE);
            directorsSignParagraph.add(Chunk.NEWLINE);
            directorsSignParagraph.add(new Chunk("Printed on " + LocalDate.now().toString() + "   At :" + LocalTime.now().toString(), printedOnFont));

            document.add(tableParagraph);
            document.add(directorsSignParagraph);

            /**
             * Log Document Details to db
             */
            HashMap<String,String> documentDetails = new HashMap<>();
            documentDetails.put("name","Employee Tax Details");
            documentDetails.put("size",document.getPageSize().toString());
            documentDetails.put("created",LocalDate.now().toString()+","+LocalTime.now().getHour()+":"+LocalTime.now().getMinute());
            documentDetails.put("location",fileObj.getParent());

  //          DocumentProcessingDaos.registerNewFile(documentDetails);

            document.close();
            
            JOptionPane.showMessageDialog(null, "Document Has Been successfully generate in (" + file + ")","Rodgermajor ticketing system",JOptionPane.INFORMATION_MESSAGE);

        } catch (FileNotFoundException | DocumentException ex) {
            ex.printStackTrace();
        }

    }

}
