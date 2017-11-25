package com.netcetera.ncau.java9beyondmodules.newwith9;

import static java.nio.charset.StandardCharsets.US_ASCII;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Tests showing the new {@link InputStream.tranferTo()} method.
 */
class InputStreamTest {

  @Test
  void transferTo() throws IOException {
    byte[] bytes = "transferTo".getBytes(US_ASCII);
    
    ByteArrayInputStream in = new ByteArrayInputStream(bytes);
    ByteArrayOutputStream out = new ByteArrayOutputStream(bytes.length);
    
    try (in; out) {
      in.transferTo(out);
      
      assertTrue(Arrays.equals(bytes, out.toByteArray()));
    }
  }  
}
