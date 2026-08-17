package com.example.hr_ai.config;

import java.io.File;
import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
@Configuration
public class HRConfig {

    @Value("classpath:/hrpolicy.txt")
    private Resource hrPolicy;


    @Bean("Hr")
    SimpleVectorStore simpleVectorStore(EmbeddingModel embeddingModel) {
        SimpleVectorStore vectorStore
                    =  SimpleVectorStore.builder(embeddingModel).build();

        File vectorStoreFile =
                new File("d:/aivectorfile/vector_store_hr.json"); 


        if(vectorStoreFile.exists()) {
            System.out.println("Loaded Vector Store File!");
            vectorStore.load(vectorStoreFile);
        } else {

            System.out.println("Create Vector File");
            TextReader textReader = new TextReader(hrPolicy);
            textReader.getCustomMetadata()
                    .put("filename", "hrpolicy.txt");
            List<Document> documents = textReader.get();

           TextSplitter textSplitter = new TokenTextSplitter();
           /* TextSplitter textSplitter = new TokenTextSplitter(
                    50,      // chunk size (tokens)
                    20,      // minimum chunk size in characters
                    5,       // minimum chunk length to embed
                    1000,    // maximum number of chunks
                    true,    // keep separators
                    List.of('.', '?', '!', ';', ':', '\n')
            );*/
            
            List<Document> splitDocuments = textSplitter.apply(documents);

            vectorStore.add(splitDocuments);
            vectorStore.save(vectorStoreFile);
        }
        return vectorStore;
    }
}
