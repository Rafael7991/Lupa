package gui;

import java.awt.Desktop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import gui.util.Constraints;

import ilog.concert.*;
import ilog.cplex.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;

import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class ViewController implements Initializable{
	@FXML private TextField txtRESSMD4K7 = new TextField();
	@FXML private TextField txtRESSMD10K5P = new TextField();
	@FXML private TextField txtRESSMD10K1P = new TextField();
	@FXML private TextField txtRESSMD68K = new TextField();
	@FXML private TextField txtRESSMD3K = new TextField();
	@FXML private TextField txtRESSMD40K = new TextField();
	@FXML private TextField txtRESSMD33K = new TextField();
	@FXML private TextField txtRESSMD4K75 = new TextField();
	@FXML private TextField txtRESSMD10 = new TextField();
	@FXML private TextField txtRESSMD18K = new TextField();
	@FXML private TextField txtRESSMD9K = new TextField();
	@FXML private TextField txtRESSMD20K = new TextField();
	@FXML private TextField txtRESSMD3K57 = new TextField();
	@FXML private TextField txtRESSMD5K = new TextField();
	@FXML private TextField txtRESSMD0R = new TextField();
	@FXML private TextField txtCAPTAN10UF = new TextField();
	@FXML private TextField txtCAPSMD47PF = new TextField();
	@FXML private TextField txtCAPSMD100NF = new TextField();
	@FXML private TextField txtCAPCER100PF = new TextField();
	@FXML private TextField txtCAPCER56NF = new TextField();
	@FXML private TextField txtCAPCER270NF = new TextField();	
	@FXML private TextField txtCAPCER2UF = new TextField();	
	@FXML private TextField txtCAPCER100NF = new TextField();
	@FXML private TextField txtINDEMI100V = new TextField();
	@FXML private TextField txtCAPELE330UF = new TextField();
	@FXML private TextField txtCAPSMD10UF = new TextField();
	@FXML private TextField txtDIOTVS33V = new TextField();
	@FXML private TextField txtRESSMD560 = new TextField();
	@FXML private TextField txtRESSMD820 = new TextField();
	@FXML private TextField txtRESSMD2K2 = new TextField();
	@FXML private TextField txtRESSMD22K = new TextField();
	@FXML private TextField txtCAPSMD2UF = new TextField();
	@FXML private TextField txtCAPSMD27PF = new TextField();
	@FXML private TextField txtCAPSMD10NF = new TextField();
	@FXML private TextField txtINDBEAD220 = new TextField();
	@FXML private TextField txtTRANSNPN45V = new TextField();
	@FXML private TextField txtTRANSPNP45V = new TextField();
	@FXML private TextField txtDIOTVS6V = new TextField();
	@FXML private TextField txtDIOTVS36V = new TextField();
	@FXML private TextField txtDIOSMD600V = new TextField();
	@FXML private TextField txtCAPELE22UF = new TextField();
	@FXML private TextField txtCILDO3V = new TextField();
	@FXML private TextField txtCIOPAMP2374 = new TextField();
	@FXML private TextField txtCISMD2LAT = new TextField();
	@FXML private TextField txtCIDAR7 = new TextField();
	@FXML private TextField txtRESSMD15K = new TextField();
	@FXML private TextField txtCIQUAD2IN = new TextField();
	@FXML private TextField txtCISMD1CH = new TextField();
	@FXML private TextField txtCIOPAMP36V = new TextField();
	@FXML private TextField txtCIMEM4MBIT = new TextField();
	@FXML private Button calcular;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("ddMMyyyy_HHmmss");
	
	
	public void calcular() throws ParseException {

		Document document = new Document(PageSize.A4);
		Date date = new Date(System.currentTimeMillis());
		String data = sdf.format(date);
		String data2 = sdf2.format(date);

		try {
			BaseFont bfTimes = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			Font times = new Font(bfTimes, 22, Font.NORMAL);
			Font times2 = new Font(bfTimes, 12, Font.NORMAL);

			PdfWriter.getInstance(document, new FileOutputStream("D:\\plan_"+data2+".pdf"));
			document.open();
			
			
	        document.add(new Paragraph("PLANEJAMENTO DE PRODUÇÃO DE RELÉS CEMIG", times));
	        document.add(new Paragraph(data, times2));

	        document.add( Chunk.NEWLINE );
			
			IloCplex cplex = new IloCplex();
			IloLinearNumExpr objective = cplex.linearNumExpr();

			IloIntVar RESSMD4K7ICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD4K7ICT");
			IloIntVar RESSMD4K7UCP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD4K7UCP");
			IloIntVar RESSMD4K7UGP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD4K7UGP");
			IloIntVar RESSMD4K7IHM = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD4K7IHM");
			
			IloIntVar RESSMD10K5PICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD10K5PICT");
			IloIntVar RESSMD10K5PUCP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD10K5PUCP");
			IloIntVar RESSMD10K5PUGP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD10K5PUGP");
			IloIntVar RESSMD10K5PIHM = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD10K5PIHM");
			IloIntVar RESSMD10K5PUPS = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD10K5PUPS");
			
			IloIntVar RESSMD10K1PICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD10K1PICT");
			IloIntVar RESSMD10K1PUPS = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD10K1PUPS");
			
			IloIntVar RESSMD68KICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD68KICT");
			IloIntVar RESSMD68KUGP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD68KUGP");
			
			IloIntVar RESSMD3KICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD3KICT");
			IloIntVar RESSMD3KUCP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD3KUCP");
			
			IloIntVar RESSMD40KICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD40KICT");
			IloIntVar RESSMD40KUPS = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD40KUPS");
			
			IloIntVar RESSMD33KICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD33KICT");
			IloIntVar RESSMD33KUPS = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD33KUPS");
			
			IloIntVar RESSMD4K75ICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD4K75ICT");
			IloIntVar RESSMD4K75UGP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD4K75UGP");
			
			IloIntVar RESSMD10ICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD10ICT");
			IloIntVar RESSMD10UPS = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD10UPS");
			
			IloIntVar RESSMD18KICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD18KICT");
			IloIntVar RESSMD18KUPS = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD18KUPS");
			
			IloIntVar RESSMD9KICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD9KICT");
			IloIntVar RESSMD9KUPS = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD9KUPS");
			
			IloIntVar RESSMD20KICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD20KICT");
			IloIntVar RESSMD20KUPS = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD20KUPS");
			
			IloIntVar RESSMD3K57ICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD3K57ICT");
			IloIntVar RESSMD3K57UPS = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD3K57UPS");
			
			IloIntVar RESSMD5KICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD5KICT");
			IloIntVar RESSMD5KUPS = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD5KUPS");
			
			IloIntVar RESSMD0RICT = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD0RICT");
			IloIntVar RESSMD0RUPS = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD0RUPS");
			
			IloIntVar CAPTAN10UFICT = cplex.intVar(0,Integer.MAX_VALUE,"CAPTAN10UFICT");
			IloIntVar CAPTAN10UFUCP = cplex.intVar(0,Integer.MAX_VALUE,"CAPTAN10UFUCP");
			IloIntVar CAPTAN10UFUGP = cplex.intVar(0,Integer.MAX_VALUE,"CAPTAN10UFUGP");
			IloIntVar CAPTAN10UFUPS = cplex.intVar(0,Integer.MAX_VALUE,"CAPTAN10UFUPS");
			
			IloIntVar CAPSMD47PFICT = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD47PFICT");
			IloIntVar CAPSMD47PFUPS = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD47PFUPS");
			
			IloIntVar CAPSMD100NFICT = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD100NFICT");
			IloIntVar CAPSMD100NFUCP = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD100NFUCP");
			IloIntVar CAPSMD100NFUGP = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD100NFUGP");
			IloIntVar CAPSMD100NFIHM = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD100NFIHM");
			IloIntVar CAPSMD100NFTRF = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD100NFTRF");
			IloIntVar CAPSMD100NFUPS = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD100NFUPS");
			
			IloIntVar CAPCER100PFICT = cplex.intVar(0,Integer.MAX_VALUE,"CAPCER100PFICT");
			IloIntVar CAPCER100PFUPS = cplex.intVar(0,Integer.MAX_VALUE,"CAPCER100PFUPS");
			
			IloIntVar CAPCER56NFICT = cplex.intVar(0,Integer.MAX_VALUE,"CAPCER56NFICT");
			IloIntVar CAPCER56NFUPS = cplex.intVar(0,Integer.MAX_VALUE,"CAPCER56NFUPS");
			
			IloIntVar CAPCER270NFICT = cplex.intVar(0,Integer.MAX_VALUE,"CAPCER270NFICT");			
			IloIntVar CAPCER270NFUPS = cplex.intVar(0,Integer.MAX_VALUE,"CAPCER270NFUPS");
			
			IloIntVar CAPCER2UFICT = cplex.intVar(0,Integer.MAX_VALUE,"CAPCER2UFICT");
			IloIntVar CAPCER2UFUPS = cplex.intVar(0,Integer.MAX_VALUE,"CAPCER2UFUPS");
			
			IloIntVar CAPCER100NFICT = cplex.intVar(0,Integer.MAX_VALUE,"CAPCER100NFICT");
			IloIntVar CAPCER100NFUPS = cplex.intVar(0,Integer.MAX_VALUE,"CAPCER100NFUPS");
			
			IloIntVar INDEMI100VIHM = cplex.intVar(0,Integer.MAX_VALUE,"INDEMI100VIHM");
			IloIntVar INDEMI100VICT = cplex.intVar(0,Integer.MAX_VALUE,"INDEMI100VICT");
			IloIntVar INDEMI100VUCP = cplex.intVar(0,Integer.MAX_VALUE,"INDEMI100VUCP");
			IloIntVar INDEMI100VUPS = cplex.intVar(0,Integer.MAX_VALUE,"INDEMI100VUPS");
			IloIntVar INDEMI100VUGP = cplex.intVar(0,Integer.MAX_VALUE,"INDEMI100VUGP");
			
			IloIntVar CAPELE330UFTRF = cplex.intVar(0,Integer.MAX_VALUE,"CAPELE330UFTRF");
			IloIntVar CAPELE330UFUCP = cplex.intVar(0,Integer.MAX_VALUE,"CAPELE330UFUCP");
			IloIntVar CAPELE330UFUPS = cplex.intVar(0,Integer.MAX_VALUE,"CAPELE330UFUPS");
			
			IloIntVar CAPSMD10UFTRF = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD10UFTRF");
			IloIntVar CAPSMD10UFUCP = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD10UFUCP");
			
			IloIntVar DIOTVS33VTRF = cplex.intVar(0,Integer.MAX_VALUE,"DIOTVS33VTRF");
			IloIntVar DIOTVS33VUCP = cplex.intVar(0,Integer.MAX_VALUE,"DIOTVS33VUCP");
			
			IloIntVar RESSMD560UCP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD560UCP");
			IloIntVar RESSMD560IHM = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD560IHM");
			
			IloIntVar RESSMD820UCP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD820UCP");
			IloIntVar RESSMD820IHM = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD820IHM");
			
			IloIntVar RESSMD2K2UCP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD2K2UCP");
			IloIntVar RESSMD2K2UGP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD2K2UGP");
			IloIntVar RESSMD2K2IHM = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD2K2IHM");
			IloIntVar RESSMD2K2UPS = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD2K2UPS");
			
			IloIntVar RESSMD22KUCP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD22KUCP");
			IloIntVar RESSMD22KUGP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD22KUGP");
			
			IloIntVar CAPSMD2UFUCP = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD2UFUCP");
			IloIntVar CAPSMD2UFUGP = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD2UFUGP");
			IloIntVar CAPSMD2UFUPS = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD2UFUPS");
			
			IloIntVar CAPSMD27PFUCP = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD27PFUCP");
			IloIntVar CAPSMD27PFIHM = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD27PFIHM");
			IloIntVar CAPSMD27PFUPS = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD27PFUPS");
			
			IloIntVar CAPSMD10NFUCP = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD10NFUCP");
			IloIntVar CAPSMD10NFUPS = cplex.intVar(0,Integer.MAX_VALUE,"CAPSMD10NFUPS");
			
			IloIntVar INDBEAD220UCP = cplex.intVar(0,Integer.MAX_VALUE,"INDBEAD220UCP");
			IloIntVar INDBEAD220UGP = cplex.intVar(0,Integer.MAX_VALUE,"INDBEAD220UGP");
			IloIntVar INDBEAD220IHM = cplex.intVar(0,Integer.MAX_VALUE,"INDBEAD220IHM");
			
			IloIntVar TRANSNPN45VUCP = cplex.intVar(0,Integer.MAX_VALUE,"TRANSNPN45VUCP");
			IloIntVar TRANSNPN45VUGP = cplex.intVar(0,Integer.MAX_VALUE,"TRANSNPN45VUGP");
			IloIntVar TRANSNPN45VIHM = cplex.intVar(0,Integer.MAX_VALUE,"TRANSNPN45VIHM");
			
			IloIntVar TRANSPNP45VUCP = cplex.intVar(0,Integer.MAX_VALUE,"TRANSPNP45VUCP");
			IloIntVar TRANSPNP45VUGP = cplex.intVar(0,Integer.MAX_VALUE,"TRANSPNP45VUGP");
			IloIntVar TRANSPNP45VIHM = cplex.intVar(0,Integer.MAX_VALUE,"TRANSPNP45VIHM");
			IloIntVar TRANSPNP45VUPS = cplex.intVar(0,Integer.MAX_VALUE,"TRANSPNP45VUPS");
			
			IloIntVar DIOTVS6VUCP = cplex.intVar(0,Integer.MAX_VALUE,"DIOTVS6VUCP");
			IloIntVar DIOTVS6VIHM = cplex.intVar(0,Integer.MAX_VALUE,"DIOTVS6VIHM");
			
			IloIntVar DIOTVS36VUGP = cplex.intVar(0,Integer.MAX_VALUE,"DIOTVS36VUGP");
			IloIntVar DIOTVS36VUCP = cplex.intVar(0,Integer.MAX_VALUE,"DIOTVS36VUCP");
			IloIntVar DIOTVS36VIHM = cplex.intVar(0,Integer.MAX_VALUE,"DIOTVS36VIHM");
			
			IloIntVar DIOSMD600VUCP = cplex.intVar(0,Integer.MAX_VALUE,"DIOSMD600VUCP");
			IloIntVar DIOSMD600VUGP = cplex.intVar(0,Integer.MAX_VALUE,"DIOSMD600VUGP");
			
			IloIntVar CAPELE22UFUGP = cplex.intVar(0,Integer.MAX_VALUE,"CAPELE22UFUGP");
			IloIntVar CAPELE22UFIHM = cplex.intVar(0,Integer.MAX_VALUE,"CAPELE22UFIHM");
			
			IloIntVar CILDO3VUCP = cplex.intVar(0,Integer.MAX_VALUE,"CILDO3VUCP");
			IloIntVar CILDO3VUGP = cplex.intVar(0,Integer.MAX_VALUE,"CILDO3VUGP");
			IloIntVar CILDO3VIHM = cplex.intVar(0,Integer.MAX_VALUE,"CILDO3VIHM");
			
			IloIntVar CIOPAMP2374ICT = cplex.intVar(0,Integer.MAX_VALUE,"CIOPAMP2374ICT");
			IloIntVar CIOPAMP2374UGP = cplex.intVar(0,Integer.MAX_VALUE,"CIOPAMP2374UGP");
			IloIntVar CIOPAMP2374UPS = cplex.intVar(0,Integer.MAX_VALUE,"CIOPAMP2374UPS");
			
			IloIntVar CISMD2LATICT = cplex.intVar(0,Integer.MAX_VALUE,"CISMD2LATICT");
			IloIntVar CISMD2LATUGP = cplex.intVar(0,Integer.MAX_VALUE,"CISMD2LATUGP");
			
			IloIntVar CIDAR7UCP = cplex.intVar(0,Integer.MAX_VALUE,"CIDAR7UCP");
			IloIntVar CIDAR7UGP = cplex.intVar(0,Integer.MAX_VALUE,"CIDAR7UGP");
			IloIntVar CIDAR7IHM = cplex.intVar(0,Integer.MAX_VALUE,"CIDAR7IHM");
			
			IloIntVar RESSMD15KUGP = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD15KUGP");
			IloIntVar RESSMD15KUPS = cplex.intVar(0,Integer.MAX_VALUE,"RESSMD15KUPS");
			
			IloIntVar CIQUAD2INUCP = cplex.intVar(0,Integer.MAX_VALUE,"CIQUAD2INUCP");
			IloIntVar CIQUAD2INIHM = cplex.intVar(0,Integer.MAX_VALUE,"CIQUAD2INIHM");
			
			IloIntVar CISMD1CHUCP = cplex.intVar(0,Integer.MAX_VALUE,"CISMD1CHUCP");
			IloIntVar CISMD1CHIHM = cplex.intVar(0,Integer.MAX_VALUE,"CISMD1CHIHM");
			
			IloIntVar CIOPAMP36VICT = cplex.intVar(0,Integer.MAX_VALUE,"CIOPAMP36VICT");
			IloIntVar CIOPAMP36VUPS = cplex.intVar(0,Integer.MAX_VALUE,"CIOPAMP36VUPS");
			
			IloIntVar CIMEM4MBITUCP = cplex.intVar(0,Integer.MAX_VALUE,"CIMEM4MBITUCP");
			IloIntVar CIMEM4MBITUPS = cplex.intVar(0,Integer.MAX_VALUE,"CIMEM4MBITUPS");
			
			if(!txtRESSMD4K7.getText().isEmpty() && Integer.parseInt(txtRESSMD4K7.getText())%26 > 0) {
				objective.addTerm(0.0046,RESSMD4K7ICT);
				objective.addTerm(0.0041,RESSMD4K7UCP);
				objective.addTerm(0.095,RESSMD4K7UGP);
				objective.addTerm(0.0139,RESSMD4K7IHM);
				cplex.addLe(cplex.prod(1, RESSMD4K7ICT),8);
				cplex.addLe(cplex.prod(1, RESSMD4K7UCP),9);
				cplex.addLe(cplex.prod(1, RESSMD4K7UGP),5);
				cplex.addLe(cplex.prod(1, RESSMD4K7IHM),4);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD4K7ICT),cplex.prod(1, RESSMD4K7UCP),cplex.prod(1, RESSMD4K7UGP),
						cplex.prod(1, RESSMD4K7IHM)),Integer.parseInt(txtRESSMD4K7.getText())%26);
			} 
			
			if(!txtRESSMD10K5P.getText().isEmpty() && Integer.parseInt(txtRESSMD10K5P.getText())%56 > 0) {
				objective.addTerm(0.0093,RESSMD10K5PICT);
				objective.addTerm(0.0095,RESSMD10K5PUGP);
				objective.addTerm(0.0011,RESSMD10K5PUCP);
				objective.addTerm(0.0062,RESSMD10K5PIHM);
				objective.addTerm(0.0111,RESSMD10K5PUPS);
				cplex.addLe(cplex.prod(1, RESSMD10K5PICT),4);
				cplex.addLe(cplex.prod(1, RESSMD10K5PUGP),5);
				cplex.addLe(cplex.prod(1, RESSMD10K5PUCP),35);
				cplex.addLe(cplex.prod(1, RESSMD10K5PIHM),9);
				cplex.addLe(cplex.prod(1, RESSMD10K5PUPS),3);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD10K5PICT),cplex.prod(1, RESSMD10K5PUGP),cplex.prod(1, RESSMD10K5PUCP),cplex.prod(1, RESSMD10K5PIHM),cplex.prod(1, RESSMD10K5PUPS)),Integer.parseInt(txtRESSMD10K5P.getText())%56);
			}
			
			if(!txtRESSMD10K1P.getText().isEmpty() && Integer.parseInt(txtRESSMD10K1P.getText())%32 > 0) {
				objective.addTerm(0.0023,RESSMD10K1PICT);
				objective.addTerm(0.0021,RESSMD10K1PUPS);
				cplex.addLe(cplex.prod(1, RESSMD10K1PICT),16);
				cplex.addLe(cplex.prod(1, RESSMD10K1PUPS),16);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD10K1PICT),cplex.prod(1, RESSMD10K1PUPS)),Integer.parseInt(txtRESSMD10K1P.getText())%32);

			}
			
			if(!txtRESSMD68K.getText().isEmpty() && Integer.parseInt(txtRESSMD68K.getText())%6 > 0) {
				objective.addTerm(0.0093,RESSMD68KICT);
				objective.addTerm(0.0238,RESSMD68KUGP);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD68KICT),cplex.prod(1, RESSMD68KUGP)),Integer.parseInt(txtRESSMD68K.getText())%6);
				cplex.addLe(cplex.prod(1, RESSMD68KICT),4);
				cplex.addLe(cplex.prod(1, RESSMD68KUGP),2);
			}
			
			if(!txtRESSMD3K.getText().isEmpty() && Integer.parseInt(txtRESSMD3K.getText())%11 > 0) {
				objective.addTerm(0.0093,RESSMD3KICT);
				objective.addTerm(0.0053,RESSMD3KUCP);
				cplex.addLe(cplex.prod(1, RESSMD3KICT),4);
				cplex.addLe(cplex.prod(1, RESSMD3KUCP),7);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD3KICT),cplex.prod(1, RESSMD3KUCP)),Integer.parseInt(txtRESSMD3K.getText())%11);
			}
			
			if(!txtRESSMD40K.getText().isEmpty() && Integer.parseInt(txtRESSMD40K.getText())%32 > 0) {
				objective.addTerm(0.0046,RESSMD40KICT);
				objective.addTerm(0.0014,RESSMD40KUPS);
				cplex.addLe(cplex.prod(1, RESSMD40KICT),8);
				cplex.addLe(cplex.prod(1, RESSMD40KUPS),24);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD40KICT),cplex.prod(1, RESSMD40KUPS)),Integer.parseInt(txtRESSMD40K.getText())%32);
			}
			
			if(!txtRESSMD33K.getText().isEmpty() && Integer.parseInt(txtRESSMD33K.getText())%16 > 0) {
				objective.addTerm(0.0093,RESSMD33KICT);
				objective.addTerm(0.0028,RESSMD33KUPS);
				cplex.addLe(cplex.prod(1, RESSMD33KICT),4);
				cplex.addLe(cplex.prod(1, RESSMD33KUPS),12);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD33KICT),cplex.prod(1, RESSMD33KUPS)),Integer.parseInt(txtRESSMD33K.getText())%16);
			}
			
			if(!txtRESSMD4K75.getText().isEmpty() && Integer.parseInt(txtRESSMD4K75.getText())%5 > 0) {
				objective.addTerm(0.0093,RESSMD4K75ICT);
				objective.addTerm(0.0476,RESSMD4K75UGP);
				cplex.addLe(cplex.prod(1, RESSMD4K75ICT),4);
				cplex.addLe(cplex.prod(1, RESSMD4K75UGP),1);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD4K75ICT),cplex.prod(1, RESSMD4K75UGP)),Integer.parseInt(txtRESSMD4K75.getText())%5);
				
			} 
			
			if(!txtRESSMD10.getText().isEmpty() && Integer.parseInt(txtRESSMD10.getText())%16 > 0) {
				objective.addTerm(0.0093,RESSMD10ICT);
				objective.addTerm(0.0028,RESSMD10UPS);
				cplex.addLe(cplex.prod(1, RESSMD10ICT),4);
				cplex.addLe(cplex.prod(1, RESSMD10UPS),12);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD10ICT),cplex.prod(1, RESSMD10UPS)),Integer.parseInt(txtRESSMD10.getText())%16);
			}
			
			if(!txtRESSMD18K.getText().isEmpty() && Integer.parseInt(txtRESSMD18K.getText())%16 > 0) {
				objective.addTerm(0.0046,RESSMD18KICT);
				objective.addTerm(0.0042,RESSMD18KUPS);
				cplex.addLe(cplex.prod(1, RESSMD18KICT),8);
				cplex.addLe(cplex.prod(1, RESSMD18KUPS),8);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD18KICT),cplex.prod(1, RESSMD18KUPS)),Integer.parseInt(txtRESSMD18K.getText())%16);
			}
			
			if(!txtRESSMD9K.getText().isEmpty() && Integer.parseInt(txtRESSMD18K.getText())%8 > 0) {
				objective.addTerm(0.0093,RESSMD9KICT);
				objective.addTerm(0.0083,RESSMD9KUPS);
				cplex.addLe(cplex.prod(1, RESSMD9KICT),4);
				cplex.addLe(cplex.prod(1, RESSMD9KUPS),4);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD9KICT),cplex.prod(1, RESSMD9KUPS)),Integer.parseInt(txtRESSMD9K.getText())%8);
			}
			
			if(!txtRESSMD20K.getText().isEmpty() && Integer.parseInt(txtRESSMD20K.getText())%16 > 0) {
				objective.addTerm(0.0093,RESSMD20KICT);
				objective.addTerm(0.0028,RESSMD20KUPS);
				cplex.addLe(cplex.prod(1, RESSMD20KICT),4);
				cplex.addLe(cplex.prod(1, RESSMD20KUPS),12);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD20KICT),cplex.prod(1, RESSMD20KUPS)),Integer.parseInt(txtRESSMD20K.getText())%16);
			}
			
			if(!txtRESSMD3K57.getText().isEmpty() && Integer.parseInt(txtRESSMD3K57.getText())%8 > 0) {
				objective.addTerm(0.0093,RESSMD3K57ICT);
				objective.addTerm(0.0083,RESSMD3K57UPS);
				cplex.addLe(cplex.prod(1, RESSMD3K57ICT),4);
				cplex.addLe(cplex.prod(1, RESSMD3K57UPS),4);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD3K57ICT),cplex.prod(1, RESSMD3K57UPS)),Integer.parseInt(txtRESSMD3K57.getText())%8);
			}
			
			if(!txtRESSMD5K.getText().isEmpty() && Integer.parseInt(txtRESSMD5K.getText())%16 > 0) {
				objective.addTerm(0.0046,RESSMD5KICT);
				objective.addTerm(0.0417,RESSMD5KUPS);
				cplex.addLe(cplex.prod(1, RESSMD5KICT),8);
				cplex.addLe(cplex.prod(1, RESSMD5KUPS),8);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD5KICT),cplex.prod(1, RESSMD5KUPS)),Integer.parseInt(txtRESSMD5K.getText())%16);
			}
			
			if(!txtRESSMD0R.getText().isEmpty() && Integer.parseInt(txtRESSMD0R.getText())%14 > 0) {
				objective.addTerm(0.0037,RESSMD0RICT);
				objective.addTerm(0.0083,RESSMD0RUPS);
				cplex.addLe(cplex.prod(1, RESSMD0RICT),10);
				cplex.addLe(cplex.prod(1, RESSMD0RUPS),4);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD0RICT),cplex.prod(1, RESSMD0RUPS)),Integer.parseInt(txtRESSMD0R.getText())%14);
			}
			
			if(!txtCAPTAN10UF.getText().isEmpty() && Integer.parseInt(txtCAPTAN10UF.getText())%33 > 0) {
				objective.addTerm(0.0034,CAPTAN10UFICT);
				objective.addTerm(0.0238,CAPTAN10UFUGP);
				objective.addTerm(0.0093,CAPTAN10UFUCP);
				objective.addTerm(0.021,CAPTAN10UFUPS);
				cplex.addLe(cplex.prod(1, CAPTAN10UFICT),11);
				cplex.addLe(cplex.prod(1, CAPTAN10UFUGP),2);
				cplex.addLe(cplex.prod(1, CAPTAN10UFUCP),4);
				cplex.addLe(cplex.prod(1, CAPTAN10UFUPS),16);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPTAN10UFICT),cplex.prod(1, CAPTAN10UFUGP),cplex.prod(1, CAPTAN10UFUCP),cplex.prod(1, CAPTAN10UFUPS)),Integer.parseInt(txtCAPTAN10UF.getText())%33);
			}
			
			if(!txtCAPSMD47PF.getText().isEmpty() && Integer.parseInt(txtCAPSMD47PF.getText())%16 > 0) {
				objective.addTerm(0.0046,CAPSMD47PFICT);
				objective.addTerm(0.0417,CAPSMD47PFUPS);
				cplex.addLe(cplex.prod(1, CAPSMD47PFICT),8);
				cplex.addLe(cplex.prod(1, CAPSMD47PFUPS),8);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPSMD47PFICT),cplex.prod(1, CAPSMD47PFUPS)),Integer.parseInt(txtCAPSMD47PF.getText())%16);
			}
			
			if(!txtCAPSMD100NF.getText().isEmpty() && Integer.parseInt(txtCAPSMD100NF.getText())%177 > 0) {
				objective.addTerm(0.0025,CAPSMD100NFICT);
				objective.addTerm(0.0043,CAPSMD100NFUGP);
				objective.addTerm(0.006,CAPSMD100NFUCP);
				objective.addTerm(0.0028,CAPSMD100NFIHM);
				objective.addTerm(0.005,CAPSMD100NFUPS);
				objective.addTerm(0.083,CAPSMD100NFTRF);
				cplex.addLe(cplex.prod(1, CAPSMD100NFICT),15);
				cplex.addLe(cplex.prod(1, CAPSMD100NFUGP),11);
				cplex.addLe(cplex.prod(1, CAPSMD100NFUCP),63);
				cplex.addLe(cplex.prod(1, CAPSMD100NFIHM),20);
				cplex.addLe(cplex.prod(1, CAPSMD100NFUPS),65);
				cplex.addLe(cplex.prod(1, CAPSMD100NFTRF),3);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPSMD100NFICT),cplex.prod(1, CAPSMD100NFUGP),cplex.prod(1, CAPSMD100NFUCP),cplex.prod(1, CAPSMD100NFIHM),cplex.prod(1, CAPSMD100NFUPS),cplex.prod(1, CAPSMD100NFTRF)),Integer.parseInt(txtCAPSMD100NF.getText())%177);
			}
			
			if(!txtCAPCER100PF.getText().isEmpty() && Integer.parseInt(txtCAPCER100PF.getText())%24 > 0) {
				objective.addTerm(0.0031,CAPCER100PFICT);
				objective.addTerm(0.0028,CAPCER100PFUPS);
				cplex.addLe(cplex.prod(1, CAPCER100PFICT),12);
				cplex.addLe(cplex.prod(1, CAPCER100PFUPS),12);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPCER100PFICT),cplex.prod(1, CAPCER100PFUPS)),Integer.parseInt(txtCAPCER100PF.getText())%24);
			}
			
			if(!txtCAPCER56NF.getText().isEmpty()&& Integer.parseInt(txtCAPCER56NF.getText())%8 > 0) {
				objective.addTerm(0.0093,CAPCER56NFICT);
				objective.addTerm(0.0083,CAPCER56NFUPS);
				cplex.addLe(cplex.prod(1, CAPCER56NFICT),4);
				cplex.addLe(cplex.prod(1, CAPCER56NFUPS),4);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPCER56NFICT),cplex.prod(1, CAPCER56NFUPS)),Integer.parseInt(txtCAPCER56NF.getText())%8);
			}
			
			if(!txtCAPCER270NF.getText().isEmpty()&& Integer.parseInt(txtCAPCER270NF.getText())%8 > 0) {
				objective.addTerm(0.0093,CAPCER270NFICT);
				objective.addTerm(0.0083,CAPCER270NFUPS);
				cplex.addLe(cplex.prod(1, CAPCER270NFICT),4);
				cplex.addLe(cplex.prod(1, CAPCER270NFUPS),4);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPCER270NFICT),cplex.prod(1, CAPCER270NFUPS)),Integer.parseInt(txtCAPCER270NF.getText())%8);
			}
			
			if(!txtCAPCER2UF.getText().isEmpty() && Integer.parseInt(txtCAPCER2UF.getText())%16 > 0) {
				objective.addTerm(0.0031,CAPCER2UFICT);
				objective.addTerm(0.0083,CAPCER2UFUPS);
				cplex.addLe(cplex.prod(1, CAPCER2UFICT),12);
				cplex.addLe(cplex.prod(1, CAPCER2UFUPS),4);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPCER2UFICT),cplex.prod(1, CAPCER2UFUPS)),Integer.parseInt(txtCAPCER2UF.getText())%16);
			}
			
			if(!txtCAPCER100NF.getText().isEmpty() && Integer.parseInt(txtCAPCER100NF.getText())%8 > 0) {
				objective.addTerm(0.0093,CAPCER100NFICT);
				objective.addTerm(0.028,CAPCER100NFUPS);
				cplex.addLe(cplex.prod(1, CAPCER100NFICT),4);
				cplex.addLe(cplex.prod(1, CAPCER100NFUPS),4);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPCER100NFICT),cplex.prod(1, CAPCER100NFUPS)),Integer.parseInt(txtCAPCER100NF.getText())%8);
			}
			
			if(!txtINDEMI100V.getText().isEmpty() && Integer.parseInt(txtINDEMI100V.getText())%21 > 0) {
				objective.addTerm(0.0046,INDEMI100VICT);
				objective.addTerm(0.0083,INDEMI100VUPS);
				objective.addTerm(0.019, INDEMI100VUCP);
				objective.addTerm(0.0278,INDEMI100VIHM);
				objective.addTerm(0.0476,INDEMI100VUGP);
				cplex.addLe(cplex.prod(1, INDEMI100VICT),8);
				cplex.addLe(cplex.prod(1, INDEMI100VUPS),7);
				cplex.addLe(cplex.prod(1, INDEMI100VUCP),2);
				cplex.addLe(cplex.prod(1, INDEMI100VIHM),2);
				cplex.addLe(cplex.prod(1, INDEMI100VUGP),2);
				cplex.addLe(cplex.sum(cplex.prod(1, INDEMI100VICT),cplex.prod(1, INDEMI100VUPS),cplex.prod(1, INDEMI100VUCP),cplex.prod(1, INDEMI100VIHM),cplex.prod(1, INDEMI100VUGP)),Integer.parseInt(txtINDEMI100V.getText())%21);
			}
			
			if(!txtCAPELE330UF.getText().isEmpty() && Integer.parseInt(txtCAPELE330UF.getText())%9 > 0) {
				objective.addTerm(0.083,CAPELE330UFTRF);
				objective.addTerm(0.037,CAPELE330UFUCP);
				objective.addTerm(0.006,CAPELE330UFUPS);
				cplex.addLe(cplex.prod(1, CAPELE330UFTRF),3);
				cplex.addLe(cplex.prod(1, CAPELE330UFUCP),1);
				cplex.addLe(cplex.prod(1, CAPELE330UFUPS),5);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPELE330UFTRF),cplex.prod(1, CAPELE330UFUCP),cplex.prod(1, CAPELE330UFUPS)),Integer.parseInt(txtCAPELE330UF.getText())%9);
			}
			
			if(!txtCAPSMD10UF.getText().isEmpty() && Integer.parseInt(txtCAPSMD10UF.getText())%10 > 0) {
				objective.addTerm(0.031,CAPSMD10UFTRF);
				objective.addTerm(0.019,CAPSMD10UFUCP);
				cplex.addLe(cplex.prod(1, CAPSMD10UFTRF),8);
				cplex.addLe(cplex.prod(1, CAPSMD10UFUCP),2);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPSMD10UFTRF),cplex.prod(1, CAPSMD10UFUCP)),Integer.parseInt(txtCAPSMD10UF.getText())%10);
			}
			
			if(!txtDIOTVS33V.getText().isEmpty() && Integer.parseInt(txtDIOTVS33V.getText())%28 > 0) {
				objective.addTerm(0.0125,DIOTVS33VTRF);
				objective.addTerm(0.0046,DIOTVS33VUCP);
				cplex.addLe(cplex.prod(1, DIOTVS33VTRF),20);
				cplex.addLe(cplex.prod(1, DIOTVS33VUCP),8);
				cplex.addLe(cplex.sum(cplex.prod(1, DIOTVS33VTRF),cplex.prod(1, DIOTVS33VUCP)),Integer.parseInt(txtDIOTVS33V.getText())%28);
			}
			
			if(!txtRESSMD560.getText().isEmpty() && Integer.parseInt(txtRESSMD560.getText())%4 > 0) {
				objective.addTerm(0.0555,RESSMD560IHM);
				objective.addTerm(0.0012,RESSMD560UCP);
				cplex.addLe(cplex.prod(1, RESSMD560IHM),1);
				cplex.addLe(cplex.prod(1, RESSMD560UCP),3);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD560IHM),cplex.prod(1, RESSMD560UCP)),Integer.parseInt(txtRESSMD560.getText())%4);
			}
			
			if(!txtRESSMD820.getText().isEmpty() && Integer.parseInt(txtRESSMD820.getText())%11 > 0) {
				objective.addTerm(0.0278,RESSMD820IHM);
				objective.addTerm(0.041,RESSMD820UCP);
				cplex.addLe(cplex.prod(1, RESSMD820IHM),2);
				cplex.addLe(cplex.prod(1, RESSMD820UCP),9);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD820IHM),cplex.prod(1, RESSMD820UCP)),Integer.parseInt(txtRESSMD820.getText())%11);
			}
			
			if(!txtRESSMD2K2.getText().isEmpty() && Integer.parseInt(txtRESSMD2K2.getText())%46 > 0) {
				objective.addTerm(0.0111,RESSMD2K2UPS);
				objective.addTerm(0.001,RESSMD2K2UCP);
				objective.addTerm(0.0185,RESSMD2K2IHM);
				objective.addTerm(0.0159,RESSMD2K2UGP);
				cplex.addLe(cplex.prod(1, RESSMD2K2UPS),3);
				cplex.addLe(cplex.prod(1, RESSMD2K2UCP),37);
				cplex.addLe(cplex.prod(1, RESSMD2K2IHM),3);
				cplex.addLe(cplex.prod(1, RESSMD2K2UGP),3);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD2K2UPS),cplex.prod(1, RESSMD2K2UCP),cplex.prod(1, RESSMD2K2IHM),cplex.prod(1, RESSMD2K2UGP)),Integer.parseInt(txtRESSMD2K2.getText())%46);
			}
			
			if(!txtRESSMD22K.getText().isEmpty() && Integer.parseInt(txtRESSMD22K.getText())%18 > 0) {
				objective.addTerm(0.0476,RESSMD22KUGP);
				objective.addTerm(0.0022,RESSMD22KUCP);
				cplex.addLe(cplex.prod(1, RESSMD22KUGP),1);
				cplex.addLe(cplex.prod(1, RESSMD22KUCP),17);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD22KUGP),cplex.prod(1, RESSMD22KUCP)),Integer.parseInt(txtRESSMD22K.getText())%18);
			}
			
			if(!txtCAPSMD2UF.getText().isEmpty() && Integer.parseInt(txtCAPSMD2UF.getText())%5 > 0) {
				objective.addTerm(0.0476,CAPSMD2UFUGP);
				objective.addTerm(0.018,CAPSMD2UFUCP);
				objective.addTerm(0.0166,CAPSMD2UFUPS);
				cplex.addLe(cplex.prod(1, CAPSMD2UFUGP),1);
				cplex.addLe(cplex.prod(1, CAPSMD2UFUCP),2);
				cplex.addLe(cplex.prod(1, CAPSMD2UFUPS),2);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPSMD2UFUGP),cplex.prod(1, CAPSMD2UFUCP),cplex.prod(1, CAPSMD2UFUPS)),Integer.parseInt(txtCAPSMD2UF.getText())%5);
			}
			
			if(!txtCAPSMD27PF.getText().isEmpty() && Integer.parseInt(txtCAPSMD27PF.getText())%8 > 0) {
				objective.addTerm(0.0277,CAPSMD27PFIHM);
				objective.addTerm(0.0092,CAPSMD27PFUCP);
				objective.addTerm(0.016,CAPSMD27PFUPS);
				cplex.addLe(cplex.prod(1, CAPSMD27PFIHM),2);
				cplex.addLe(cplex.prod(1, CAPSMD27PFUCP),4);
				cplex.addLe(cplex.prod(1, CAPSMD27PFUPS),2);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPSMD27PFIHM),cplex.prod(1, CAPSMD27PFUCP),cplex.prod(1, CAPSMD27PFUPS)),Integer.parseInt(txtCAPSMD27PF.getText())%8);
			}
			
			if(!txtCAPSMD10NF.getText().isEmpty() && Integer.parseInt(txtCAPSMD10NF.getText())%5 > 0) {
				objective.addTerm(0.0111,CAPSMD10NFUPS);
				objective.addTerm(0.018,CAPSMD10NFUCP);
				cplex.addLe(cplex.prod(1, CAPSMD10NFUPS),3);
				cplex.addLe(cplex.prod(1, CAPSMD10NFUCP),2);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPSMD10NFUPS),cplex.prod(1, CAPSMD10NFUCP)),Integer.parseInt(txtCAPSMD10NF.getText())%5);
			}
			
			if(!txtINDBEAD220.getText().isEmpty() && Integer.parseInt(txtINDBEAD220.getText())%9 > 0) {
				objective.addTerm(0.0139,INDBEAD220IHM);
				objective.addTerm(0.018,INDBEAD220UCP);
				objective.addTerm(0.0159,INDBEAD220UGP);
				cplex.addLe(cplex.prod(1, INDBEAD220IHM),4);
				cplex.addLe(cplex.prod(1, INDBEAD220UCP),2);
				cplex.addLe(cplex.prod(1, INDBEAD220UGP),3);
				cplex.addLe(cplex.sum(cplex.prod(1, INDBEAD220IHM),cplex.prod(1, INDBEAD220UCP),cplex.prod(1, INDBEAD220UGP)),Integer.parseInt(txtINDBEAD220.getText())%9);
			}
			
			if(!txtTRANSNPN45V.getText().isEmpty() && Integer.parseInt(txtTRANSNPN45V.getText())%5 > 0) {
				objective.addTerm(0.0277,TRANSNPN45VIHM);
				objective.addTerm(0.037,TRANSNPN45VUCP);
				objective.addTerm(0.0238,TRANSNPN45VUGP);
				cplex.addLe(cplex.prod(1, TRANSNPN45VIHM),2);
				cplex.addLe(cplex.prod(1, TRANSNPN45VUCP),1);
				cplex.addLe(cplex.prod(1, TRANSNPN45VUGP),2);
				cplex.addLe(cplex.sum(cplex.prod(1, TRANSNPN45VIHM),cplex.prod(1, TRANSNPN45VUCP),cplex.prod(1, TRANSNPN45VUGP)),Integer.parseInt(txtTRANSNPN45V.getText())%5);
			}
			
			if(!txtTRANSPNP45V.getText().isEmpty() && Integer.parseInt(txtTRANSPNP45V.getText())%6 > 0) {
				objective.addTerm(0.0555,TRANSPNP45VIHM);
				objective.addTerm(0.012,TRANSPNP45VUCP);
				objective.addTerm(0.0238,TRANSPNP45VUGP);
				objective.addTerm(0.0333,TRANSPNP45VUPS);
				cplex.addLe(cplex.prod(1, TRANSPNP45VIHM),1);
				cplex.addLe(cplex.prod(1, TRANSPNP45VUCP),3);
				cplex.addLe(cplex.prod(1, TRANSPNP45VUGP),1);
				cplex.addLe(cplex.prod(1, TRANSPNP45VUPS),1);
				cplex.addLe(cplex.sum(cplex.prod(1, TRANSPNP45VIHM),cplex.prod(1, TRANSPNP45VUCP),cplex.prod(1, TRANSPNP45VUGP),cplex.prod(1, TRANSPNP45VUPS)),Integer.parseInt(txtTRANSPNP45V.getText())%6);
			}
			
			if(!txtDIOTVS6V.getText().isEmpty() && Integer.parseInt(txtDIOTVS6V.getText())%2 > 0) {
				objective.addTerm(0.0555,DIOTVS6VIHM);
				objective.addTerm(0.037,DIOTVS6VUCP);
				cplex.addLe(cplex.prod(1, DIOTVS6VIHM),1);
				cplex.addLe(cplex.prod(1, DIOTVS6VUCP),1);
				cplex.addLe(cplex.sum(cplex.prod(1, DIOTVS6VIHM),cplex.prod(1, DIOTVS6VUCP)),Integer.parseInt(txtDIOTVS6V.getText())%2);
			}
			
			if(!txtDIOTVS36V.getText().isEmpty() && Integer.parseInt(txtDIOTVS36V.getText())%16 > 0) {
				objective.addTerm(0.0555,DIOTVS36VIHM);
				objective.addTerm(0.0036,DIOTVS36VUCP);
				objective.addTerm(0.0068,DIOTVS36VUGP);
				cplex.addLe(cplex.prod(1, DIOTVS36VIHM),1);
				cplex.addLe(cplex.prod(1, DIOTVS36VUCP),8);
				cplex.addLe(cplex.prod(1, DIOTVS36VUGP),7);
				cplex.addLe(cplex.sum(cplex.prod(1, DIOTVS36VIHM),cplex.prod(1, DIOTVS36VUCP),cplex.prod(1, DIOTVS36VUGP)),Integer.parseInt(txtDIOTVS36V.getText())%16);
			}
			
			if(!txtDIOSMD600V.getText().isEmpty() && Integer.parseInt(txtDIOSMD600V.getText())%15 > 0) {
				objective.addTerm(0.0036,DIOSMD600VUCP);
				objective.addTerm(0.0068,DIOSMD600VUGP);
				cplex.addLe(cplex.prod(1, DIOSMD600VUCP),8);
				cplex.addLe(cplex.prod(1, DIOSMD600VUGP),7);
				cplex.addLe(cplex.sum(cplex.prod(1, DIOSMD600VUCP),cplex.prod(1, DIOSMD600VUGP)),Integer.parseInt(txtDIOSMD600V.getText())%15);
			}
			
			if(!txtCAPELE22UF.getText().isEmpty() && Integer.parseInt(txtCAPELE22UF.getText())%3 > 0) {
				objective.addTerm(0.0555,CAPELE22UFIHM);
				objective.addTerm(0.0238,CAPELE22UFUGP);
				cplex.addLe(cplex.prod(1, CAPELE22UFIHM),1);
				cplex.addLe(cplex.prod(1, CAPELE22UFUGP),2);
				cplex.addLe(cplex.sum(cplex.prod(1, CAPELE22UFIHM),cplex.prod(1, CAPELE22UFUGP)),Integer.parseInt(txtCAPELE22UF.getText())%3);
			}
			
			if(!txtCILDO3V.getText().isEmpty() && Integer.parseInt(txtCILDO3V.getText())%3 > 0) {
				objective.addTerm(0.0555,CILDO3VIHM);
				objective.addTerm(0.0476,CILDO3VUGP);
				objective.addTerm(0.037,CILDO3VUCP);
				cplex.addLe(cplex.prod(1, CILDO3VIHM),1);
				cplex.addLe(cplex.prod(1, CILDO3VUGP),1);
				cplex.addLe(cplex.prod(1, CILDO3VUCP),1);
				cplex.addLe(cplex.sum(cplex.prod(1, CILDO3VIHM),cplex.prod(1, CILDO3VUGP),cplex.prod(1, CILDO3VUCP)),Integer.parseInt(txtCILDO3V.getText())%3);
			}
			
			if(!txtCIOPAMP2374.getText().isEmpty() && Integer.parseInt(txtCIOPAMP2374.getText())%6 > 0) {
				objective.addTerm(0.037,CIOPAMP2374ICT);
				objective.addTerm(0.0476,CIOPAMP2374UGP);
				objective.addTerm(0.0083,CIOPAMP2374UPS);
				cplex.addLe(cplex.prod(1, CIOPAMP2374ICT),1);
				cplex.addLe(cplex.prod(1, CIOPAMP2374UGP),1);
				cplex.addLe(cplex.prod(1, CIOPAMP2374UPS),4);
				cplex.addLe(cplex.sum(cplex.prod(1, CIOPAMP2374ICT),cplex.prod(1, CIOPAMP2374UGP),cplex.prod(1, CIOPAMP2374UPS)),Integer.parseInt(txtCIOPAMP2374.getText())%6);
			}
			
			if(!txtCISMD2LAT.getText().isEmpty() && Integer.parseInt(txtCISMD2LAT.getText())%3 > 0) {
				objective.addTerm(0.018,CISMD2LATICT);
				objective.addTerm(0.0476,CISMD2LATUGP);
				cplex.addLe(cplex.prod(1, CISMD2LATICT),2);
				cplex.addLe(cplex.prod(1, CISMD2LATUGP),1);
				cplex.addLe(cplex.sum(cplex.prod(1, CISMD2LATICT),cplex.prod(1, CISMD2LATUGP)),Integer.parseInt(txtCISMD2LAT.getText())%3);
			}
			
			if(!txtCIDAR7.getText().isEmpty() && Integer.parseInt(txtCIDAR7.getText())%8 > 0) {
				objective.addTerm(0.037,CIDAR7UCP);
				objective.addTerm(0.0238,CIDAR7UGP);
				objective.addTerm(0.0111,CIDAR7IHM);
				cplex.addLe(cplex.prod(1, CIDAR7UCP),1);
				cplex.addLe(cplex.prod(1, CIDAR7UGP),2);
				cplex.addLe(cplex.prod(1, CIDAR7IHM),5);
				cplex.addLe(cplex.sum(cplex.prod(1, CIDAR7UCP),cplex.prod(1, CIDAR7UGP),cplex.prod(1, CIDAR7IHM)),Integer.parseInt(txtCIDAR7.getText())%8);
			}
			
			if(!txtRESSMD15K.getText().isEmpty() && Integer.parseInt(txtRESSMD15K.getText())%5 > 0) {
				objective.addTerm(0.0083,RESSMD15KUPS);
				objective.addTerm(0.0476,RESSMD15KUGP);
				cplex.addLe(cplex.prod(1, RESSMD15KUPS),4);
				cplex.addLe(cplex.prod(1, RESSMD15KUGP),1);
				cplex.addLe(cplex.sum(cplex.prod(1, RESSMD15KUPS),cplex.prod(1, RESSMD15KUGP)),Integer.parseInt(txtRESSMD15K.getText())%5);
			}	
			
			if(!txtCIQUAD2IN.getText().isEmpty() && Integer.parseInt(txtCIQUAD2IN.getText())%2 > 0) {
				objective.addTerm(0.037,CIQUAD2INUCP);
				objective.addTerm(0.0555,CIQUAD2INIHM);
				cplex.addLe(cplex.prod(1, CIQUAD2INUCP),1);
				cplex.addLe(cplex.prod(1, CIQUAD2INIHM),1);
				cplex.addLe(cplex.sum(cplex.prod(1, CIQUAD2INUCP),cplex.prod(1, CIQUAD2INIHM)),Integer.parseInt(txtCIQUAD2IN.getText())%2);
			}
			
			if(!txtCISMD1CH.getText().isEmpty() && Integer.parseInt(txtCISMD1CH.getText())%12 > 0) {
				objective.addTerm(0.0037,CISMD1CHUCP);
				objective.addTerm(0.0277,CISMD1CHIHM);
				cplex.addLe(cplex.prod(1, CISMD1CHUCP),10);
				cplex.addLe(cplex.prod(1, CISMD1CHIHM),2);
				cplex.addLe(cplex.sum(cplex.prod(1, CISMD1CHUCP),cplex.prod(1, CISMD1CHIHM)),Integer.parseInt(txtCISMD1CH.getText())%12);
			}
			
			if(!txtCIOPAMP36V.getText().isEmpty() && Integer.parseInt(txtCIOPAMP36V.getText())%8 > 0) {
				objective.addTerm(0.0093,CIOPAMP36VICT);
				objective.addTerm(0.0083,CIOPAMP36VUPS);
				cplex.addLe(cplex.prod(1, CIOPAMP36VICT),4);
				cplex.addLe(cplex.prod(1, CIOPAMP36VUPS),4);
				cplex.addLe(cplex.sum(cplex.prod(1, CIOPAMP36VICT),cplex.prod(1, CIOPAMP36VUPS)),Integer.parseInt(txtCIOPAMP36V.getText())%8);
			}
			
			if(!txtCIMEM4MBIT.getText().isEmpty() && Integer.parseInt(txtCIMEM4MBIT.getText())%3 > 0) {
				objective.addTerm(0.018,CIMEM4MBITUCP);
				objective.addTerm(0.0333,CIMEM4MBITUPS);
				cplex.addLe(cplex.prod(1, CIMEM4MBITUCP),2);
				cplex.addLe(cplex.prod(1, CIMEM4MBITUPS),1);
				cplex.addLe(cplex.sum(cplex.prod(1, CIMEM4MBITUCP),cplex.prod(1, CIMEM4MBITUPS)),Integer.parseInt(txtCIMEM4MBIT.getText())%3);
				
			}
			
			cplex.addMaximize(objective);
			
			if(cplex.solve()) {
				System.out.println(cplex.getObjValue());
				if(Integer.parseInt(txtRESSMD4K7.getText())%26 == 0) {
					document.add(new Paragraph("RESISTOR 4K7: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD4K7.getText())/26)*8 )+
							", UCP: "+Math.round((int)(Integer.parseInt(txtRESSMD4K7.getText())/26)*9 )+
							", UGP: "+Math.round((int)(Integer.parseInt(txtRESSMD4K7.getText())/26)*5 )+
							", IHM: "+Math.round((int)(Integer.parseInt(txtRESSMD4K7.getText())/26)*4 ) ));
					document.add( Chunk.NEWLINE );
					
				} else {
					document.add(new Paragraph("RESISTOR 4K7: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD4K7ICT) + (int)(Integer.parseInt(txtRESSMD4K7.getText())/26)*8 )+
							", UCP: "+Math.round(cplex.getValue(RESSMD4K7UCP) + (int)(Integer.parseInt(txtRESSMD4K7.getText())/26)*9 )+
							", UGP: "+Math.round(cplex.getValue(RESSMD4K7UGP) + (int)(Integer.parseInt(txtRESSMD4K7.getText())/26)*5 )+
							", IHM: "+Math.round(cplex.getValue(RESSMD4K7UCP) + (int)(Integer.parseInt(txtRESSMD4K7.getText())/26)*4 ) ));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD10K5P.getText())%56 == 0) {
					document.add(new Paragraph("RESISTOR 10K 5%: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD10K5P.getText())/56)*4 )+", UCP: "+Math.round((int)(Integer.parseInt(txtRESSMD10K5P.getText())/56)*35 )+", UGP: "+Math.round((int)(Integer.parseInt(txtRESSMD10K5P.getText())/56)*5 )+", IHM: "+Math.round((int)(Integer.parseInt(txtRESSMD10K5P.getText())/56)*9 )+", UPS: "+Math.round((int)(Integer.parseInt(txtRESSMD10K5P.getText())/56)*3 ) ));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("RESISTOR 10K 5%: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD10K5PICT) + (int)(Integer.parseInt(txtRESSMD10K5P.getText())/56)*4 )+", UCP: "+Math.round(cplex.getValue(RESSMD10K5PUCP) + (int)(Integer.parseInt(txtRESSMD10K5P.getText())/56)*35 )+", UGP: "+Math.round(cplex.getValue(RESSMD10K5PUGP) + (int)(Integer.parseInt(txtRESSMD10K5P.getText())/56)*5 )+", IHM: "+Math.round(cplex.getValue(RESSMD10K5PIHM) + (int)(Integer.parseInt(txtRESSMD10K5P.getText())/56)*9 )+", UPS: "+Math.round(cplex.getValue(RESSMD10K5PUPS) + (int)(Integer.parseInt(txtRESSMD10K5P.getText())/56)*3 ) ));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtRESSMD10K1P.getText())%32 == 0) {
					document.add(new Paragraph("RESISTOR 10K 1%: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD10K1P.getText())/32)*16 )+", UPS: "+Math.round((int)(Integer.parseInt(txtRESSMD10K1P.getText())/32)*16 ) ));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("RESISTOR 10K 1%: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD10K1PICT) + (int)(Integer.parseInt(txtRESSMD10K1P.getText())/32)*16 )+", UPS: "+Math.round(cplex.getValue(RESSMD10K1PUPS) + (int)(Integer.parseInt(txtRESSMD10K1P.getText())/32)*16 ) ));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD68K.getText())%6 == 0) {
					document.add(new Paragraph("RESISTOR 68K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD68K.getText())/6)*4 )+", UGP: "+Math.round((int)(Integer.parseInt(txtRESSMD68K.getText())/6)*2 ) ));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("RESISTOR 68K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD68KICT) + (int)(Integer.parseInt(txtRESSMD68K.getText())/6)*4 )+", UGP: "+Math.round(cplex.getValue(RESSMD68KUGP) + (int)(Integer.parseInt(txtRESSMD68K.getText())/6)*2 ) ));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD3K.getText())%11 == 0) {
					document.add(new Paragraph("RESISTOR 3K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD3K.getText())/11)*4 )+", UCP: "+Math.round((int)(Integer.parseInt(txtRESSMD3K.getText())/11)*7 ) ));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("RESISTOR 3K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD3KICT) + (int)(Integer.parseInt(txtRESSMD3K.getText())/11)*4 )+", UCP: "+Math.round(cplex.getValue(RESSMD3KUCP) + (int)(Integer.parseInt(txtRESSMD3K.getText())/11)*7 ) ));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD40K.getText())%32 == 0) {
					document.add(new Paragraph("RESISTOR 40K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD40K.getText())/32)*8 )+", UPS: "+Math.round((int)(Integer.parseInt(txtRESSMD40K.getText())/32)*24 ) ));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("RESISTOR 40K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD40KICT) + (int)(Integer.parseInt(txtRESSMD40K.getText())/32)*8 )+", UPS: "+Math.round(cplex.getValue(RESSMD40KUPS) + (int)(Integer.parseInt(txtRESSMD40K.getText())/32)*24 ) ));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD33K.getText())%16 == 0) {
					document.add(new Paragraph("RESISTOR 33K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD33K.getText())/16)*4 )+", UPS: "+Math.round((int)(Integer.parseInt(txtRESSMD33K.getText())/16)*12 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("RESISTOR 33K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD33KICT) + (int)(Integer.parseInt(txtRESSMD33K.getText())/16)*4 )+", UPS: "+Math.round(cplex.getValue(RESSMD33KUPS) + (int)(Integer.parseInt(txtRESSMD33K.getText())/16)*12 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD4K75.getText())%5 == 0) {
					document.add(new Paragraph("RESISTOR 4K75: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD4K75.getText())/5)*4 )+", UGP: "+Math.round((int)(Integer.parseInt(txtRESSMD4K75.getText())/5)*1 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("RESISTOR 4K75: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD4K75ICT) + (int)(Integer.parseInt(txtRESSMD4K75.getText())/5)*4 )+", UGP: "+Math.round(cplex.getValue(RESSMD4K75UGP) + (int)(Integer.parseInt(txtRESSMD4K75.getText())/5)*1 )));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtRESSMD10.getText())%16 == 0) {
					document.add(new Paragraph("RESISTOR 10: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD10.getText())/16)*4 )+", UPS: "+Math.round((int)(Integer.parseInt(txtRESSMD10.getText())/16)*12 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("RESISTOR 10: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD10ICT) + (int)(Integer.parseInt(txtRESSMD10.getText())/16)*4 )+", UPS: "+Math.round(cplex.getValue(RESSMD10UPS) + (int)(Integer.parseInt(txtRESSMD10.getText())/16)*12 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD18K.getText())%16 == 0) {
					document.add(new Paragraph("RESISTOR 18K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD18K.getText())/16)*8 )+", UPS: "+Math.round((int)(Integer.parseInt(txtRESSMD18K.getText())/16)*8 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("RESISTOR 18K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD18KICT) + (int)(Integer.parseInt(txtRESSMD18K.getText())/16)*8 )+", UPS: "+Math.round(cplex.getValue(RESSMD18KUPS) + (int)(Integer.parseInt(txtRESSMD18K.getText())/16)*8 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD9K.getText())%8 == 0) {
					document.add(new Paragraph("RESISTOR 9K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD9K.getText())/8)*4 )+", UPS: "+Math.round((int)(Integer.parseInt(txtRESSMD9K.getText())/8)*4 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("RESISTOR 9K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD9KICT) + (int)(Integer.parseInt(txtRESSMD9K.getText())/8)*4 )+", UPS: "+Math.round(cplex.getValue(RESSMD9KUPS) + (int)(Integer.parseInt(txtRESSMD4K7.getText())/8)*4 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD20K.getText())%16 == 0) {
					document.add(new Paragraph("RESISTOR 20K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD20K.getText())/16)*4 )+", UPS: "+Math.round((int)(Integer.parseInt(txtRESSMD20K.getText())/16)*12 )));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("RESISTOR 20K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD20KICT) + (int)(Integer.parseInt(txtRESSMD20K.getText())/16)*4 )+", UPS: "+Math.round(cplex.getValue(RESSMD20KUPS) + (int)(Integer.parseInt(txtRESSMD20K.getText())/16)*12 )));
					

					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD3K57.getText())%8 == 0) {
					document.add(new Paragraph("RESISTOR 3K57: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD3K57.getText())/8)*4 )+", UPS: "+Math.round((int)(Integer.parseInt(txtRESSMD3K57.getText())/8)*4 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("RESISTOR 3K57: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD3K57ICT) + (int)(Integer.parseInt(txtRESSMD3K57.getText())/8)*4 )+", UPS: "+Math.round(cplex.getValue(RESSMD3K57UPS) + (int)(Integer.parseInt(txtRESSMD3K57.getText())/8)*4 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD5K.getText())%16 == 0) {
					document.add(new Paragraph("RESISTOR 5K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD5K.getText())/16)*8 )+", UPS: "+Math.round((int)(Integer.parseInt(txtRESSMD5K.getText())/16)*8 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("RESISTOR 5K: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD5KICT) + (int)(Integer.parseInt(txtRESSMD5K.getText())/16)*8 )+", UPS: "+Math.round(cplex.getValue(RESSMD5KUPS) + (int)(Integer.parseInt(txtRESSMD5K.getText())/16)*8 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD0R.getText())%14 == 0) {
					document.add(new Paragraph("RESISTOR 0: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtRESSMD0R.getText())/14)*10 )+", UPS: "+Math.round((int)(Integer.parseInt(txtRESSMD0R.getText())/14)*4 )));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("RESISTOR 0: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(RESSMD0RICT) + (int)(Integer.parseInt(txtRESSMD0R.getText())/14)*10 )+", UPS: "+Math.round(cplex.getValue(RESSMD0RUPS) + (int)(Integer.parseInt(txtRESSMD0R.getText())/14)*4 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtCAPTAN10UF.getText())%33 == 0) {
					document.add(new Paragraph("CAPACITOR TANTALO 10UF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtCAPTAN10UF.getText())/33)*11 )+", UCP: "+Math.round((int)(Integer.parseInt(txtCAPTAN10UF.getText())/33)*4 )+", UGP: "+Math.round((int)(Integer.parseInt(txtRESSMD4K7.getText())/33)*2 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCAPTAN10UF.getText())/33)*16 ) ));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("CAPACITOR TANTALO 10UF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(CAPTAN10UFICT) + (int)(Integer.parseInt(txtCAPTAN10UF.getText())/33)*11 )+", UCP: "+Math.round(cplex.getValue(CAPTAN10UFUCP) + (int)(Integer.parseInt(txtCAPTAN10UF.getText())/33)*4 )+", UGP: "+Math.round(cplex.getValue(CAPTAN10UFUGP) + (int)(Integer.parseInt(txtRESSMD4K7.getText())/33)*2 )+", UPS: "+Math.round(cplex.getValue(CAPTAN10UFUPS) + (int)(Integer.parseInt(txtCAPTAN10UF.getText())/33)*16 ) ));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtCAPSMD47PF.getText())%16 == 0) {
					document.add(new Paragraph("CAPACITOR 47PF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtCAPSMD47PF.getText())/16)*8 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCAPSMD47PF.getText())/16)*8 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("CAPACITOR 47PF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(CAPSMD47PFICT) + (int)(Integer.parseInt(txtCAPSMD47PF.getText())/16)*8 )+", UPS: "+Math.round(cplex.getValue(CAPSMD47PFUPS) + (int)(Integer.parseInt(txtCAPSMD47PF.getText())/16)*8 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtCAPSMD100NF.getText())%177 == 0) {
					document.add(new Paragraph("CAPACITOR 100NF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtCAPSMD100NF.getText())/177)*15 )+", UCP: "+Math.round((int)(Integer.parseInt(txtCAPSMD100NF.getText())/177)*63 )+", UGP: "+Math.round((int)(Integer.parseInt(txtCAPSMD100NF.getText())/177)*11 )+", IHM: "+Math.round((int)(Integer.parseInt(txtCAPSMD100NF.getText())/177)*20 )+", TRF: "+Math.round((int)(Integer.parseInt(txtCAPSMD100NF.getText())/177)*3 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCAPSMD100NF.getText())/177)*65 )));
					document.add( Chunk.NEWLINE );
					
				} else {
					document.add(new Paragraph("CAPACITOR 100NF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(CAPSMD100NFICT) + (int)(Integer.parseInt(txtCAPSMD100NF.getText())/177)*15 )+", UCP: "+Math.round(cplex.getValue(CAPSMD100NFUCP) + (int)(Integer.parseInt(txtCAPSMD100NF.getText())/177)*63 )+", UGP: "+Math.round(cplex.getValue(CAPSMD100NFUGP) + (int)(Integer.parseInt(txtCAPSMD100NF.getText())/177)*11 )+", IHM: "+Math.round(cplex.getValue(CAPSMD100NFIHM) + (int)(Integer.parseInt(txtCAPSMD100NF.getText())/177)*20 )+", TRF: "+Math.round(cplex.getValue(CAPSMD100NFTRF) + (int)(Integer.parseInt(txtCAPSMD100NF.getText())/177)*3 )+", UPS: "+Math.round(cplex.getValue(CAPSMD100NFUPS) + (int)(Integer.parseInt(txtCAPSMD100NF.getText())/177)*65 )    ));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtCAPCER100PF.getText())%24 == 0) {
					document.add(new Paragraph("CAPACITOR CERAMICA 100PF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtCAPCER100PF.getText())/24)*12 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCAPCER100PF.getText())/24)*12 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("CAPACITOR CERAMICA 100PF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(CAPCER100PFICT) + (int)(Integer.parseInt(txtCAPCER100PF.getText())/24)*12 )+", UPS: "+Math.round(cplex.getValue(CAPCER100PFUPS) + (int)(Integer.parseInt(txtCAPCER100PF.getText())/24)*12 )));
					document.add( Chunk.NEWLINE );

				}
					
				if(Integer.parseInt(txtCAPCER56NF.getText())%8 == 0) {
					document.add(new Paragraph("CAPACITOR CERAMICA 56NF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtCAPCER56NF.getText())/8)*4 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCAPCER56NF.getText())/8)*4 )));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("CAPACITOR CERAMICA 56NF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(CAPCER56NFICT) + (int)(Integer.parseInt(txtCAPCER56NF.getText())/8)*4 )+", UPS: "+Math.round(cplex.getValue(CAPCER56NFUPS) + (int)(Integer.parseInt(txtCAPCER56NF.getText())/8)*4 )));
					document.add( Chunk.NEWLINE );
				}

				if(Integer.parseInt(txtCAPCER270NF.getText())%8 == 0) {
					document.add(new Paragraph("CAPACITOR CERAMICA 270NF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtCAPCER270NF.getText())/8)*4 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCAPCER270NF.getText())/8)*4 )));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("CAPACITOR CERAMICA 270NF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(CAPCER270NFICT) + (int)(Integer.parseInt(txtCAPCER270NF.getText())/8)*4 )+", UPS: "+Math.round(cplex.getValue(CAPCER270NFUPS) + (int)(Integer.parseInt(txtCAPCER270NF.getText())/8)*4 )));
					document.add( Chunk.NEWLINE );
				}

				if(Integer.parseInt(txtCAPCER2UF.getText())%16 == 0) {
					document.add(new Paragraph("CAPACITOR CERAMICA 2UF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtCAPCER2UF.getText())/16)*12 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCAPCER2UF.getText())/16)*4 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("CAPACITOR CERAMICA 2UF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(CAPCER2UFICT) + (int)(Integer.parseInt(txtCAPCER2UF.getText())/16)*12 )+", UPS: "+Math.round(cplex.getValue(CAPCER2UFUPS) + (int)(Integer.parseInt(txtCAPCER2UF.getText())/16)*4 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtCAPCER100NF.getText())%8 == 0) {
					document.add(new Paragraph("CAPACITOR CERAMICA 100NF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtCAPCER100NF.getText())/8)*4 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCAPCER100NF.getText())/8)*4 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("CAPACITOR CERAMICA 100NF: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(CAPCER100NFICT) + (int)(Integer.parseInt(txtCAPCER100NF.getText())/8)*4 )+", UPS: "+Math.round(cplex.getValue(CAPCER100NFUPS) + (int)(Integer.parseInt(txtCAPCER100NF.getText())/8)*4 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtINDEMI100V.getText())%21 == 0) {
					document.add(new Paragraph("INDUTOR 100V: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtINDEMI100V.getText())/21)*8 )+", UCP: "+Math.round((int)(Integer.parseInt(txtINDEMI100V.getText())/21)*2 )+", UPS: "+Math.round((int)(Integer.parseInt(txtINDEMI100V.getText())/21)*7 )+", UGP: "+Math.round((int)(Integer.parseInt(txtINDEMI100V.getText())/21)*2 )+", IHM: "+Math.round((int)(Integer.parseInt(txtINDEMI100V.getText())/21)*2 ) ));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("INDUTOR 100V: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(INDEMI100VICT) + (int)(Integer.parseInt(txtINDEMI100V.getText())/21)*8 )+", UCP: "+Math.round(cplex.getValue(INDEMI100VUCP) + (int)(Integer.parseInt(txtINDEMI100V.getText())/21)*2 )+", UPS: "+Math.round(cplex.getValue(INDEMI100VUPS) + (int)(Integer.parseInt(txtINDEMI100V.getText())/21)*7 )+", UGP: "+Math.round(cplex.getValue(INDEMI100VUGP) + (int)(Integer.parseInt(txtINDEMI100V.getText())/21)*2 )+", IHM: "+Math.round(cplex.getValue(INDEMI100VIHM) + (int)(Integer.parseInt(txtINDEMI100V.getText())/21)*2 ) ));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtCAPELE330UF.getText())%9 == 0) {
					document.add(new Paragraph("CAPACITOR ELETROLITICO 330UF: ")) ;
					document.add(new Paragraph("TRF: "+Math.round((int)(Integer.parseInt(txtCAPELE330UF.getText())/9)*3 )+", UCP: "+Math.round((int)(Integer.parseInt(txtCAPELE330UF.getText())/9)*1 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCAPELE330UF.getText())/9)*5 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("CAPACITOR ELETROLITICO 330UF: ")) ;
					document.add(new Paragraph("TRF: "+Math.round(cplex.getValue(CAPELE330UFTRF) + (int)(Integer.parseInt(txtCAPELE330UF.getText())/9)*3 )+", UCP: "+Math.round(cplex.getValue(CAPELE330UFUCP) + (int)(Integer.parseInt(txtCAPELE330UF.getText())/9)*1 )+", UPS: "+Math.round(cplex.getValue(CAPELE330UFUPS) + (int)(Integer.parseInt(txtCAPELE330UF.getText())/9)*5 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtCAPSMD10UF.getText())%10 == 0) {
					document.add(new Paragraph("CAPACITOR 10UF: ")) ;
					document.add(new Paragraph("TRF: "+Math.round((int)(Integer.parseInt(txtCAPSMD10UF.getText())/10)*8 )+", UCP: "+Math.round((int)(Integer.parseInt(txtCAPSMD10UF.getText())/10)*2 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("CAPACITOR 10UF: ")) ;
					document.add(new Paragraph("TRF: "+Math.round(cplex.getValue(CAPSMD10UFTRF) + (int)(Integer.parseInt(txtCAPSMD10UF.getText())/10)*8 )+", UCP: "+Math.round(cplex.getValue(CAPSMD10UFUCP) + (int)(Integer.parseInt(txtCAPSMD10UF.getText())/10)*2 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtDIOTVS33V.getText())%28 == 0) {
					document.add(new Paragraph("DIODO TVS 33V: ")) ;
					document.add(new Paragraph("TRF: "+Math.round((int)(Integer.parseInt(txtDIOTVS33V.getText())/28)*20 )+", UCP: "+Math.round((int)(Integer.parseInt(txtDIOTVS33V.getText())/28)*8 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("DIODO TVS 33V: ")) ;
					document.add(new Paragraph("TRF: "+Math.round(cplex.getValue(DIOTVS33VTRF) + (int)(Integer.parseInt(txtDIOTVS33V.getText())/28)*20 )+", UCP: "+Math.round(cplex.getValue(DIOTVS33VUCP) + (int)(Integer.parseInt(txtDIOTVS33V.getText())/28)*8 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD560.getText())%4 == 0) {
					document.add(new Paragraph("RESISTOR 560: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtRESSMD560.getText())/4)*3 )+", IHM: "+Math.round((int)(Integer.parseInt(txtRESSMD560.getText())/4)*1 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("RESISTOR 560: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(RESSMD560UCP) + (int)(Integer.parseInt(txtRESSMD560.getText())/4)*3 )+", IHM: "+Math.round(cplex.getValue(RESSMD560IHM) + (int)(Integer.parseInt(txtRESSMD560.getText())/4)*1 )));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtRESSMD820.getText())%11 == 0) {
					document.add(new Paragraph("RESISTOR 820: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtRESSMD820.getText())/11)*9 )+", IHM: "+Math.round((int)(Integer.parseInt(txtRESSMD820.getText())/11)*2 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("RESISTOR 820: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(RESSMD820UCP) + (int)(Integer.parseInt(txtRESSMD820.getText())/11)*9 )+", IHM: "+Math.round(cplex.getValue(RESSMD820IHM) + (int)(Integer.parseInt(txtRESSMD820.getText())/11)*2 )));
					document.add( Chunk.NEWLINE );
				}
					
				if(Integer.parseInt(txtRESSMD2K2.getText())%46 == 0) {
					document.add(new Paragraph("RESISTOR 2K2: ")) ;
					document.add(new Paragraph("UGP: "+Math.round((int)(Integer.parseInt(txtRESSMD2K2.getText())/46)*37 )+", UGP: "+Math.round((int)(Integer.parseInt(txtRESSMD2K2.getText())/46)*3 )+", IHM: "+Math.round((int)(Integer.parseInt(txtRESSMD2K2.getText())/46)*3 )+", UPS: "+Math.round((int)(Integer.parseInt(txtRESSMD2K2.getText())/46)*3 ) ));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("RESISTOR 2K2: ")) ;
					document.add(new Paragraph("UGP: "+Math.round(cplex.getValue(RESSMD2K2UCP) + (int)(Integer.parseInt(txtRESSMD2K2.getText())/46)*37 )+", UGP: "+Math.round(cplex.getValue(RESSMD2K2UGP) + (int)(Integer.parseInt(txtRESSMD2K2.getText())/46)*3 )+", IHM: "+Math.round(cplex.getValue(RESSMD2K2IHM) + (int)(Integer.parseInt(txtRESSMD2K2.getText())/46)*3 )+", UPS: "+Math.round(cplex.getValue(RESSMD2K2UPS) + (int)(Integer.parseInt(txtRESSMD2K2.getText())/46)*3 ) ));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtRESSMD22K.getText())%18 == 0) {
					document.add(new Paragraph("RESISTOR 22K: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtRESSMD22K.getText())/18)*17 )+", UGP: "+Math.round((int)(Integer.parseInt(txtRESSMD22K.getText())/18)*1 )));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("RESISTOR 22K: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(RESSMD22KUCP) + (int)(Integer.parseInt(txtRESSMD22K.getText())/18)*17 )+", UGP: "+Math.round(cplex.getValue(RESSMD22KUGP) + (int)(Integer.parseInt(txtRESSMD22K.getText())/18)*1 )));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtCAPSMD2UF.getText())%5 == 0) {
					document.add(new Paragraph("CAPACITOR 2UF: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtCAPSMD2UF.getText())/5)*2 )+", UGP: "+Math.round((int)(Integer.parseInt(txtCAPSMD2UF.getText())/5)*1 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCAPSMD2UF.getText())/5)*2 )));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("CAPACITOR 2UF: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(CAPSMD2UFUCP) + (int)(Integer.parseInt(txtCAPSMD2UF.getText())/5)*2 )+", UGP: "+Math.round(cplex.getValue(CAPSMD2UFUGP) + (int)(Integer.parseInt(txtCAPSMD2UF.getText())/5)*1 )+", UPS: "+Math.round(cplex.getValue(CAPSMD2UFUPS) + (int)(Integer.parseInt(txtCAPSMD2UF.getText())/5)*2 )));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtCAPSMD27PF.getText())%8 == 0) {
					document.add(new Paragraph("CAPACITOR 27PF: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtCAPSMD27PF.getText())/8)*4 )+", IHM: "+Math.round((int)(Integer.parseInt(txtCAPSMD27PF.getText())/8)*2 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCAPSMD27PF.getText())/8)*2 )));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("CAPACITOR 27PF: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(CAPSMD27PFUCP) + (int)(Integer.parseInt(txtCAPSMD27PF.getText())/8)*4 )+", IHM: "+Math.round(cplex.getValue(CAPSMD27PFIHM) + (int)(Integer.parseInt(txtCAPSMD27PF.getText())/8)*2 )+", UPS: "+Math.round(cplex.getValue(CAPSMD27PFUPS) + (int)(Integer.parseInt(txtCAPSMD27PF.getText())/8)*2 )));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtCAPSMD10NF.getText())%5 == 0) {
					document.add(new Paragraph("CAPACITOR 10NF: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtCAPSMD10NF.getText())/5)*2 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCAPSMD10NF.getText())/5)*3 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("CAPACITOR 10NF: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(CAPSMD10NFUCP) + (int)(Integer.parseInt(txtCAPSMD10NF.getText())/5)*2 )+", UPS: "+Math.round(cplex.getValue(CAPSMD10NFUPS) + (int)(Integer.parseInt(txtCAPSMD10NF.getText())/5)*3 )));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtINDBEAD220.getText())%9 == 0) {
					document.add(new Paragraph("INDUTOR F.BEAD: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtINDBEAD220.getText())/9)*2 )+", UGP: "+Math.round((int)(Integer.parseInt(txtINDBEAD220.getText())/9)*3 )+", IHM: "+Math.round((int)(Integer.parseInt(txtINDBEAD220.getText())/9)*4 ) ));
					document.add( Chunk.NEWLINE );	
				} else {
					document.add(new Paragraph("INDUTOR F.BEAD: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(INDBEAD220UCP) + (int)(Integer.parseInt(txtINDBEAD220.getText())/9)*2 )+", UGP: "+Math.round(cplex.getValue(INDBEAD220UGP) + (int)(Integer.parseInt(txtINDBEAD220.getText())/9)*3 )+", IHM: "+Math.round(cplex.getValue(INDBEAD220IHM) + (int)(Integer.parseInt(txtINDBEAD220.getText())/9)*4 ) ));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtTRANSNPN45V.getText())%5 == 0) {
					document.add(new Paragraph("TRANSISTOR NPN 45V: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtTRANSNPN45V.getText())/5)*1 )+", UGP: "+Math.round((int)(Integer.parseInt(txtTRANSNPN45V.getText())/5)*2 )+", IHM: "+Math.round((int)(Integer.parseInt(txtTRANSNPN45V.getText())/5)*2 ) ));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("TRANSISTOR NPN 45V: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(TRANSNPN45VUCP) + (int)(Integer.parseInt(txtTRANSNPN45V.getText())/5)*1 )+", UGP: "+Math.round(cplex.getValue(TRANSNPN45VUGP) + (int)(Integer.parseInt(txtTRANSNPN45V.getText())/5)*2 )+", IHM: "+Math.round(cplex.getValue(TRANSNPN45VIHM) + (int)(Integer.parseInt(txtTRANSNPN45V.getText())/5)*2 ) ));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtTRANSPNP45V.getText())%6 == 0) {
					document.add(new Paragraph("TRANSISTOR PNP 45V: ")) ;
					document.add(new Paragraph("UPS: "+Math.round((int)(Integer.parseInt(txtTRANSPNP45V.getText())/6)*3 )+", UCP: "+Math.round((int)(Integer.parseInt(txtTRANSPNP45V.getText())/6)*3 )+", UGP: "+Math.round((int)(Integer.parseInt(txtTRANSPNP45V.getText())/6)*1 )+", IHM: "+Math.round((int)(Integer.parseInt(txtTRANSPNP45V.getText())/6)*1 ) ));
					document.add( Chunk.NEWLINE );				
				}else {
					document.add(new Paragraph("TRANSISTOR PNP 45V: ")) ;
					document.add(new Paragraph("UPS: "+Math.round(cplex.getValue(TRANSPNP45VUPS) + (int)(Integer.parseInt(txtTRANSPNP45V.getText())/6)*3 )+", UCP: "+Math.round(cplex.getValue(TRANSPNP45VUCP) + (int)(Integer.parseInt(txtTRANSPNP45V.getText())/6)*3 )+", UGP: "+Math.round(cplex.getValue(TRANSPNP45VUGP) + (int)(Integer.parseInt(txtTRANSPNP45V.getText())/26)*5 )+", IHM: "+Math.round(cplex.getValue(TRANSPNP45VIHM) + (int)(Integer.parseInt(txtTRANSPNP45V.getText())/6)*1 ) ));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtDIOTVS6V.getText())%2 == 0) {
					document.add(new Paragraph("DIODO TVS 6V: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtDIOTVS6V.getText())/2)*1 )+", IHM: "+Math.round((int)(Integer.parseInt(txtDIOTVS6V.getText())/2)*1 )));
					document.add( Chunk.NEWLINE );

				} else {
					document.add(new Paragraph("DIODO TVS 6V: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(DIOTVS6VUCP) + (int)(Integer.parseInt(txtDIOTVS6V.getText())/2)*1 )+", IHM: "+Math.round(cplex.getValue(DIOTVS6VIHM) + (int)(Integer.parseInt(txtDIOTVS6V.getText())/2)*1 )));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtDIOTVS36V.getText())%16 == 0) {
					document.add(new Paragraph("DIODO TVS 36V: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtDIOTVS36V.getText())/16)*8 )+", UGP: "+Math.round((int)(Integer.parseInt(txtDIOTVS36V.getText())/16)*7 )+", IHM: "+Math.round((int)(Integer.parseInt(txtDIOTVS36V.getText())/16)*1 ) ));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("DIODO TVS 36V: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(DIOTVS36VUCP) + (int)(Integer.parseInt(txtDIOTVS36V.getText())/16)*8 )+", UGP: "+Math.round(cplex.getValue(DIOTVS36VUGP) + (int)(Integer.parseInt(txtDIOTVS36V.getText())/16)*7 )+", IHM: "+Math.round(cplex.getValue(DIOTVS36VIHM) + (int)(Integer.parseInt(txtDIOTVS36V.getText())/16)*1 ) ));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtDIOSMD600V.getText())%15 == 0) {
					document.add(new Paragraph("DIODO 600V: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtDIOSMD600V.getText())/15)*8 )+", UGP: "+Math.round((int)(Integer.parseInt(txtDIOSMD600V.getText())/15)*7 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("DIODO 600V: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(DIOSMD600VUCP) + (int)(Integer.parseInt(txtDIOSMD600V.getText())/15)*8 )+", UGP: "+Math.round(cplex.getValue(DIOSMD600VUGP) + (int)(Integer.parseInt(txtDIOSMD600V.getText())/15)*7 )));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtCAPELE22UF.getText())%3 == 0) {
					document.add(new Paragraph("CAPACITOR ELETROLITICO 22UF: ")) ;
					document.add(new Paragraph("UGP: "+Math.round((int)(Integer.parseInt(txtCAPELE22UF.getText())/3)*2 )+", IHM: "+Math.round((int)(Integer.parseInt(txtCAPELE22UF.getText())/3)*1 ) ));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("CAPACITOR ELETROLITICO 22UF: ")) ;
					document.add(new Paragraph("UGP: "+Math.round(cplex.getValue(CAPELE22UFUGP) + (int)(Integer.parseInt(txtCAPELE22UF.getText())/3)*2 )+", IHM: "+Math.round(cplex.getValue(CAPELE22UFIHM) + (int)(Integer.parseInt(txtCAPELE22UF.getText())/3)*1 ) ));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtCILDO3V.getText())%3 == 0) {
					document.add(new Paragraph("CI LDO 3,3V: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtCILDO3V.getText())/3)*1 )+", UGP: "+Math.round((int)(Integer.parseInt(txtCILDO3V.getText())/3)*1 )+", IHM: "+Math.round((int)(Integer.parseInt(txtCILDO3V.getText())/3)*1 ) ));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("CI LDO 3,3V: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(CILDO3VUCP) + (int)(Integer.parseInt(txtCILDO3V.getText())/3)*1 )+", UGP: "+Math.round(cplex.getValue(CILDO3VUGP) + (int)(Integer.parseInt(txtCILDO3V.getText())/3)*1 )+", IHM: "+Math.round(cplex.getValue(CILDO3VIHM) + (int)(Integer.parseInt(txtCILDO3V.getText())/3)*1 ) ));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtCIOPAMP2374.getText())%6 == 0) {
					document.add(new Paragraph("CI AMP 2374: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtCIOPAMP2374.getText())/6)*1 )+", UGP: "+Math.round((int)(Integer.parseInt(txtCIOPAMP2374.getText())/6)*1 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCIOPAMP2374.getText())/6)*4 )));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("CI AMP 2374: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(CIOPAMP2374ICT) + (int)(Integer.parseInt(txtCIOPAMP2374.getText())/6)*1 )+", UGP: "+Math.round(cplex.getValue(CIOPAMP2374UGP) + (int)(Integer.parseInt(txtCIOPAMP2374.getText())/6)*1 )+", UPS: "+Math.round(cplex.getValue(CIOPAMP2374UPS) + (int)(Integer.parseInt(txtCIOPAMP2374.getText())/6)*4 )));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtCISMD2LAT.getText())%3 == 0) {
					document.add(new Paragraph("CI CD4066BM: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtCISMD2LAT.getText())/3)*2 )+", UGP: "+Math.round((int)(Integer.parseInt(txtCISMD2LAT.getText())/3)*1 )));
					document.add( Chunk.NEWLINE );

				} else {
					document.add(new Paragraph("CI CD4066BM: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(CISMD2LATICT) + (int)(Integer.parseInt(txtCISMD2LAT.getText())/3)*2 )+", UGP: "+Math.round(cplex.getValue(CISMD2LATUGP) + (int)(Integer.parseInt(txtCISMD2LAT.getText())/3)*1 )));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtCIDAR7.getText())%8 == 0) {
					document.add(new Paragraph("CI 7-DARLINGTON: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtCIDAR7.getText())/8)*1 )+", UGP: "+Math.round((int)(Integer.parseInt(txtCIDAR7.getText())/8)*2 )+", IHM: "+Math.round((int)(Integer.parseInt(txtCIDAR7.getText())/8)*5 ) ));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("CI 7-DARLINGTON: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(CIDAR7UCP) + (int)(Integer.parseInt(txtCIDAR7.getText())/8)*1 )+", UGP: "+Math.round(cplex.getValue(CIDAR7UGP) + (int)(Integer.parseInt(txtCIDAR7.getText())/8)*2 )+", IHM: "+Math.round(cplex.getValue(CIDAR7IHM) + (int)(Integer.parseInt(txtCIDAR7.getText())/8)*5 ) ));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtRESSMD15K.getText())%5 == 0) {
					document.add(new Paragraph("RESISTOR 15K: ")) ;
					document.add(new Paragraph("UGP: "+Math.round((int)(Integer.parseInt(txtRESSMD15K.getText())/5)*1 )+", UPS: "+Math.round((int)(Integer.parseInt(txtRESSMD15K.getText())/5)*4 )));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("RESISTOR 15K: ")) ;
					document.add(new Paragraph("UGP: "+Math.round(cplex.getValue(RESSMD15KUGP) + (int)(Integer.parseInt(txtRESSMD15K.getText())/5)*1 )+", UPS: "+Math.round(cplex.getValue(RESSMD15KUPS) + (int)(Integer.parseInt(txtRESSMD15K.getText())/5)*4 )));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtCIQUAD2IN.getText())%2 == 0) {
					document.add(new Paragraph("CI SN74HC00D: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtCIQUAD2IN.getText())/2)*1 )+", IHM: "+Math.round((int)(Integer.parseInt(txtCIQUAD2IN.getText())/2)*1 ) ));
					document.add( Chunk.NEWLINE );
				} else {
					document.add(new Paragraph("CI SN74HC00D: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(CIQUAD2INUCP) + (int)(Integer.parseInt(txtCIQUAD2IN.getText())/2)*1 )+", IHM: "+Math.round(cplex.getValue(CIQUAD2INIHM) + (int)(Integer.parseInt(txtCIQUAD2IN.getText())/2)*1 ) ));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtCISMD1CH.getText())%12 == 0) {
					document.add(new Paragraph("CI 6N137SDM: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtCISMD1CH.getText())/12)*10 )+", IHM: "+Math.round((int)(Integer.parseInt(txtCISMD1CH.getText())/12)*2 ) ));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("CI 6N137SDM: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(CISMD1CHUCP) + (int)(Integer.parseInt(txtCISMD1CH.getText())/12)*10 )+", IHM: "+Math.round(cplex.getValue(CISMD1CHIHM) + (int)(Integer.parseInt(txtCISMD1CH.getText())/12)*10 )));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtCIOPAMP36V.getText())%8 == 0) {
					document.add(new Paragraph("CI OPA4180IDR: ")) ;
					document.add(new Paragraph("ICT: "+Math.round((int)(Integer.parseInt(txtCIOPAMP36V.getText())/8)*4 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCIOPAMP36V.getText())/8)*4 )));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("CI OPA4180IDR: ")) ;
					document.add(new Paragraph("ICT: "+Math.round(cplex.getValue(CIOPAMP36VICT) + (int)(Integer.parseInt(txtCIOPAMP36V.getText())/8)*4 )+", UPS: "+Math.round(cplex.getValue(CIOPAMP36VUPS) + (int)(Integer.parseInt(txtCIOPAMP36V.getText())/8)*4 )));
					document.add( Chunk.NEWLINE );
				}
				
				if(Integer.parseInt(txtCIMEM4MBIT.getText())%3 == 0) {
					document.add(new Paragraph("CI AT45DB041E-SHN-B: ")) ;
					document.add(new Paragraph("UCP: "+Math.round((int)(Integer.parseInt(txtCIMEM4MBIT.getText())/3)*2 )+", UPS: "+Math.round((int)(Integer.parseInt(txtCIMEM4MBIT.getText())/3)*1 )));
					document.add( Chunk.NEWLINE );
				}else {
					document.add(new Paragraph("CI AT45DB041E-SHN-B: ")) ;
					document.add(new Paragraph("UCP: "+Math.round(cplex.getValue(CIMEM4MBITUCP) + (int)(Integer.parseInt(txtCIMEM4MBIT.getText())/3)*2 )+", UPS: "+Math.round(cplex.getValue(CIMEM4MBITUPS) + (int)(Integer.parseInt(txtCIMEM4MBIT.getText())/3)*1 )));
					document.add( Chunk.NEWLINE );
				}
				
				File pdfFile = new File("D:\\plan_"+data2+".pdf");
				if (pdfFile.exists()) {

					if (Desktop.isDesktopSupported()) {
						Desktop.getDesktop().open(pdfFile);
					} else {
						System.out.println("Awt Desktop is not supported!");
					}
				}
				
			}

		cplex.close();
		}catch(IloException e) {
			e.printStackTrace();
		}
		catch(DocumentException a) {
			a.printStackTrace();
		}
		
		catch(IOException b) {
			b.printStackTrace();
		} 
		finally {
			document.close();
		}
	}	
	
	public void ajuda() throws IOException {
		File file = new File("ajuda.png");
		Desktop desktop = Desktop.getDesktop();  
		desktop.open(file);
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldInteger(txtRESSMD4K7);
		Constraints.setTextFieldInteger(txtRESSMD10K5P);
		Constraints.setTextFieldInteger(txtRESSMD10K1P);
		Constraints.setTextFieldInteger(txtRESSMD68K);
		Constraints.setTextFieldInteger(txtRESSMD3K);
		Constraints.setTextFieldInteger(txtRESSMD40K);
		Constraints.setTextFieldInteger(txtRESSMD33K);
		Constraints.setTextFieldInteger(txtRESSMD4K75);
		Constraints.setTextFieldInteger(txtRESSMD10);
		Constraints.setTextFieldInteger(txtRESSMD18K);
		Constraints.setTextFieldInteger(txtRESSMD9K);
		Constraints.setTextFieldInteger(txtRESSMD20K);
		Constraints.setTextFieldInteger(txtRESSMD3K57);
		Constraints.setTextFieldInteger(txtRESSMD5K);
		Constraints.setTextFieldInteger(txtRESSMD0R);
		Constraints.setTextFieldInteger(txtCAPTAN10UF);
		Constraints.setTextFieldInteger(txtCAPSMD47PF);
		Constraints.setTextFieldInteger(txtCAPCER56NF);
		Constraints.setTextFieldInteger(txtCAPCER270NF);
		Constraints.setTextFieldInteger(txtCAPCER2UF);
		Constraints.setTextFieldInteger(txtCAPCER100NF);
		Constraints.setTextFieldInteger(txtINDEMI100V);
		Constraints.setTextFieldInteger(txtCAPELE330UF);
		Constraints.setTextFieldInteger(txtCAPSMD10UF);
		Constraints.setTextFieldInteger(txtDIOTVS33V);
		Constraints.setTextFieldInteger(txtRESSMD560);
		Constraints.setTextFieldInteger(txtRESSMD820);
		Constraints.setTextFieldInteger(txtRESSMD2K2);
		Constraints.setTextFieldInteger(txtRESSMD22K);
		Constraints.setTextFieldInteger(txtCAPSMD2UF);
		Constraints.setTextFieldInteger(txtCAPSMD27PF);
		Constraints.setTextFieldInteger(txtCAPSMD10NF);
		Constraints.setTextFieldInteger(txtINDBEAD220);
		Constraints.setTextFieldInteger(txtTRANSNPN45V);
		Constraints.setTextFieldInteger(txtTRANSPNP45V);
		Constraints.setTextFieldInteger(txtDIOTVS6V);
		Constraints.setTextFieldInteger(txtDIOTVS36V);
		Constraints.setTextFieldInteger(txtDIOSMD600V);
		Constraints.setTextFieldInteger(txtCAPELE22UF);
		Constraints.setTextFieldInteger(txtCILDO3V);
		Constraints.setTextFieldInteger(txtCIOPAMP2374);
		Constraints.setTextFieldInteger(txtCISMD2LAT);
		Constraints.setTextFieldInteger(txtCIDAR7);
		Constraints.setTextFieldInteger(txtRESSMD15K);
		Constraints.setTextFieldInteger(txtCIQUAD2IN);
		Constraints.setTextFieldInteger(txtCISMD1CH);
		Constraints.setTextFieldInteger(txtCIOPAMP36V);
		Constraints.setTextFieldInteger(txtCIMEM4MBIT);
		Constraints.setTextFieldInteger(txtCAPCER100PF);
		Constraints.setTextFieldInteger(txtCAPSMD100NF);
	}	
}