package com.example.pdfFileService.Service;

import com.example.pdfFileService.Entity.pdfFile;
import com.example.pdfFileService.Repository.pdfFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class pdfFileService {
    @Autowired
    private pdfFileRepository pdffilerepository;

    public ArrayList<pdfFile> getAllFiles(){
        return (ArrayList<pdfFile>) pdffilerepository.findAll();
    }


    public List<pdfFile> getPdfFilesByCredit(Long creditId){
        return pdffilerepository.findByCreditid(creditId);
    }


    @Transactional(readOnly = true)
    public pdfFile getPdfFileByCategoryAndCredit(String category, Long creditId){
        return pdffilerepository.findByCategoryAndCreditid(category, creditId);
    };

    public pdfFile StoreFile(MultipartFile File, String category, Long creditId) throws IOException {
        pdfFile fileEntity = new pdfFile();
        fileEntity.setName(File.getOriginalFilename());
        fileEntity.setCategory(category);
        fileEntity.setData(File.getBytes());
        fileEntity.setCreditid(creditId);
        return pdffilerepository.save(fileEntity);
    }

    public pdfFile updateFile(Long id, MultipartFile file, String category, Long creditId) throws Exception{
        Optional<pdfFile> existingFile = pdffilerepository.findById(id);
        if (existingFile.isPresent()) {
            pdfFile fileEntity = existingFile.get();
            fileEntity.setName(file.getOriginalFilename());
            fileEntity.setCategory(category);
            fileEntity.setData(file.getBytes());
            fileEntity.setCreditid(creditId);
            return pdffilerepository.save(fileEntity);
        } else {
            throw new Exception("Archivo no encontrado");
        }
    }

    public boolean deletePdfFile(Long id) throws Exception{
        try {
            pdffilerepository.deleteById(id);
            return true;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
