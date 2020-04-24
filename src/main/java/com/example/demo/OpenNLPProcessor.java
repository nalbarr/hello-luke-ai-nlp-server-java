package com.example.demo;

import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import java.io.InputStream;
import java.io.FileInputStream;
import org.slf4j.Logger;

public class OpenNLPProcessor implements INLPProcessor {
    private Logger _logger = null;
    private TokenizerME _tokenizerME = null;

    public OpenNLPProcessor(Logger logger) {
         try {
            _logger = logger;
            InputStream inputStream = new FileInputStream("en-token.bin"); 
            TokenizerModel model = new TokenizerModel(inputStream);
            _tokenizerME = new TokenizerME(model);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }       
    }

    public String[] process(String s) {
        String tokens[] = null;
        try {
            tokens = _tokenizerME.tokenize(s);
            for (int i=0; i < tokens.length; i++) {
                _logger.info(String.format("%d: %s", i, tokens[i]));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return tokens;
    }  

}
