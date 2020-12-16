package edu.poly.spring.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.poly.spring.models.Reader;
import edu.poly.spring.services.ReaderService;

@Controller
public class ImageController {
	
	@Autowired
	private ReaderService readerService;
	
	@GetMapping ("getimage/{readerId}")
	@ResponseBody
	public ResponseEntity<ByteArrayResource> dowloadlinkImage(@PathVariable("readerId") String readerId){
			Optional<Reader> sop = readerService.findById(readerId);
			if (sop.isEmpty()) {
				Reader reader = sop.get();
				try {
					Path filename = Paths.get("images", reader.getPhoto());
					byte[] buffer = Files.readAllBytes(filename);
					
					ByteArrayResource bsr = new ByteArrayResource(buffer);
					return ResponseEntity.ok()
							.contentLength(buffer.length)
							.contentType(MediaType.parseMediaType("image/jpg"))
							.body(bsr);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return ResponseEntity.badRequest().build();
	}
	

}
