// CHECKSTYLE:OFF
/**
 * Source code generated by Fluent Builders Generator
 * Do not modify this file
 * See generator home page at: http://code.google.com/p/fluent-builders-generator-eclipse-plugin/
 */

package fr.epf.lastminutetraining.domain;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PdfView extends AbstractPdfView {
	protected void buildPdfDocument(Map model, Document document,
			PdfWriter writer, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		//Order order = (Order) model.get("command");

		String imageUrl = "http://oenologie.epf.fr/LMT/LMT.png";

		Image image2 = Image.getInstance(new URL(imageUrl));

		image2.scalePercent(50f);

		Paragraph header = new Paragraph(new Chunk(
				"LastMinuteTraining - Facture client", FontFactory.getFont(
						FontFactory.HELVETICA, 30)));

		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
		String date = formater.format(System.currentTimeMillis());

		Paragraph by = new Paragraph(new Chunk("Facture éditée le " + date,
				FontFactory.getFont(FontFactory.HELVETICA, 20)));

		document.add(image2);
		document.add(header);
		document.add(by);
	}
}