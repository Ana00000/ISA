package com.example.demo.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/QRCode", produces = MediaType.APPLICATION_JSON_VALUE)
public class QRCodeController {

    QRCodeController(){}

    @GetMapping(value = "/get/{barcode}"/*, produces = MediaType.IMAGE_PNG_VALUE*/)
    public ResponseEntity<Boolean> barbecueEAN13Barcode(@PathVariable String barcode)
            throws Exception {
        System.out.println("radii");
        generateQRCodeImage(barcode);
        return ResponseEntity.ok(true);
    }

    public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws Exception {
        EAN13Writer barcodeWriter = new EAN13Writer();
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.EAN_13, 300, 150);
        BufferedImage ret =MatrixToImageWriter.toBufferedImage(bitMatrix);
        File outputfile = new File("image.jpg");
        ImageIO.write(ret, "jpg", outputfile);
        return ret;
    }

    public static BufferedImage generateQRCodeImage(String barcodeText) throws Exception {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);
        BufferedImage ret=MatrixToImageWriter.toBufferedImage(bitMatrix);
        File outputfile = new File("image.jpg");
        ImageIO.write(ret, "jpg", outputfile);
        return ret;
    }

}
