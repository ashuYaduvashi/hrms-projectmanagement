package com.ncm.hrms.controller;



import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ncm.hrms.dto.common.DocumentDto;
import com.ncm.hrms.service.DocumentService;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    

    @PostMapping("/upload")
    public ResponseEntity<DocumentDto> uploadDocument(
            @RequestPart("docDto") DocumentDto docDto,
            @RequestPart("file") MultipartFile file) throws IOException {

        DocumentDto savedDoc = documentService.uploadFile(docDto, file);

        return ResponseEntity.ok(savedDoc);
    }

  

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDto> getDocumentById(@PathVariable Long id) {

        return ResponseEntity.ok(documentService.getDocumentById(id));
    }

    

    @GetMapping
    public ResponseEntity<List<DocumentDto>> getAllDocuments() {

        return ResponseEntity.ok(documentService.getAllDocuments());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable Long id) throws IOException {

        documentService.deleteDocumentById(id);

        return ResponseEntity.ok("Document deleted successfully");
    }
}
