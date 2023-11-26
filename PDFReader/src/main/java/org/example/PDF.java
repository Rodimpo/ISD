package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDF {
        public int termCount[] = new int[10];;

        public PDF(String pdfFilePath) {
            String terms[] = new String[10];
            terms[0] = "Polska";
            terms[1] = "Francja";
            terms[2] = "Niemcy";
            terms[3] = "Kanada";
            terms[4] = "Meksyk";
            terms[5] = "Australia";
            terms[6] = "Chiny";
            terms[7] = "Rosja";
            terms[8] = "Nigeria";
            terms[9] = "Brazylia";

            try {
                File file = new File(pdfFilePath);
                PDDocument document = PDDocument.load(file);

                PDFTextStripper pdfTextStripper = new PDFTextStripper();

                String pdfText = pdfTextStripper.getText(document);

                document.close();

                String[] words = pdfText.split("\\s+");

                for (int i = 0; i < 10; i++) {
                    termCount[i] = 0;
                }

                for (String word : words) {
                    if (word.contains(terms[0])) {
                        termCount[0]++;
                    }
                    if (word.contains(terms[1])) {
                        termCount[1]++;
                    }
                    if (word.contains(terms[2])) {
                        termCount[2]++;
                    }
                    if (word.contains(terms[3])) {
                        termCount[3]++;
                    }
                    if (word.contains(terms[4])) {
                        termCount[4]++;
                    }
                    if (word.contains(terms[5])) {
                        termCount[5]++;
                    }
                    if (word.contains(terms[6])) {
                        termCount[6]++;
                    }
                    if (word.contains(terms[7])) {
                        termCount[7]++;
                    }
                    if (word.contains(terms[8])) {
                        termCount[8]++;
                    }
                    if (word.contains(terms[9])) {
                        termCount[9]++;
                    }
                }

                /*for (int i = 0; i < 10; i++) {
                    System.out.println("T" + i + " (" + terms[i] + "): " + termCount[i]);
                }*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}