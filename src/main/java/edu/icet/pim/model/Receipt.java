package edu.icet.pim.model;

import edu.icet.pim.util.ImageCompressor;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Receipt {
    private byte[] receiptImage;
    public void setReceiptImage(byte[] receiptImage) {
        this.receiptImage = ImageCompressor.compress(receiptImage);
    }






}
