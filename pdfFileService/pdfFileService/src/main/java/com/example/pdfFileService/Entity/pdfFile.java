package com.example.pdfFileService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "pdffile")
@AllArgsConstructor
@NoArgsConstructor
public class pdfFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    private String name;

    @Lob
    private byte[] data;

    private Long creditid;
}
