package com.consultaJPA.uri2618;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.consultaJPA.uri2618.dto.ImportDTO;
import com.consultaJPA.uri2618.projections.ImportProjection;
import com.consultaJPA.uri2618.repositories.ImportRepository;

@SpringBootApplication
public class Uri2618Application implements CommandLineRunner{

	@Autowired
	private ImportRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2618Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<ImportProjection> list1 = repository.search1("Sansul SA", "Imported");
		List<ImportDTO> listDTO = list1.stream().map(x -> new ImportDTO(x)).collect(Collectors.toList());
		System.out.println("---------------- M O V I E S   F O U N D   S Q L ----------------");
		for (ImportDTO importDTO : listDTO) {
			System.out.println(importDTO);
		}
		System.out.println("-----------------------------------------------------------------");

		List<ImportDTO> listDTO2 = repository.search2("Sansul SA", "Imported");
		System.out.println("---------------- M O V I E S   F O U N D   J P Q L ----------------");
		for (ImportDTO importDTO : listDTO2) {
			System.out.println(importDTO);
		}
		System.out.println("-----------------------------------------------------------------");
	}

	
}
