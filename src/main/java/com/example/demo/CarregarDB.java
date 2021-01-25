package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarregarDB {
	private static final Logger log = LoggerFactory.getLogger(CarregarDB.class);
	
	@Bean
	CommandLineRunner initDataBase(EmployeeRepository repository, ProdutoRepository produtoRepository) {
		return args -> {
			log.info("Preloading " + repository.save(new Employee("João", "Garçom")));
			log.info("Preloading " + repository.save(new Employee("Maria", "Cheff")));
			log.info("Preloading " + produtoRepository.save(new Produto("Mouse", Double.valueOf(10.0), 52, "https://www.logitechstore.com.br/media/catalog/product/cache/1/image/300x/9df78eab33525d08d6e5fb8d27136e95/h/i/high_resolution_png-g203-lightsync-gaming-mouse-fob---white_1.png")));
			log.info("Preloading " + produtoRepository.save(new Produto("Fone", Double.valueOf(31.0), 35, "https://img2.gratispng.com/20180909/wir/kisspng-headphones-microphone-portable-network-graphics-he-headset-transparent-png-clip-art-image-gallery-yop-5b95e1a7b48370.0275816315365492877394.jpg")));
			log.info("Preloading " + produtoRepository.save(new Produto("Teclado", Double.valueOf(25.0), 27, "https://img2.gratispng.com/20180602/opx/kisspng-computer-keyboard-dell-optiplex-laptop-computer-mo-5b12386f8e5704.567606171527920751583.jpg")));
			log.info("Preloading " + produtoRepository.save(new Produto("Monitor", Double.valueOf(32.0), 21, "https://saude.abril.com.br/wp-content/uploads/2016/09/o-monitor-que-protege-seus-olhos.jpg")));
		};
	}
	
//	@Bean
//	CommandLineRunner initDataBase(ProdutoRepository produtoRepository) {
//		return args -> {
//			log.info("Preloading " + produtoRepository.save(new Produto("Mouse", Double.valueOf(10.0), 52, "https://www.logitechstore.com.br/media/catalog/product/cache/1/image/300x/9df78eab33525d08d6e5fb8d27136e95/h/i/high_resolution_png-g203-lightsync-gaming-mouse-fob---white_1.png")));
//		};
//	}
}
