package com.example.aula3;

import java.util.List;

import com.example.aula3.entity.Categorias;
import com.example.aula3.entity.Perfil;
import com.example.aula3.entity.Produtos;
import com.example.aula3.entity.Usuario;
import com.example.aula3.repository.CategoriaProdutoRepository;
import com.example.aula3.repository.PerfilRepository;
import com.example.aula3.repository.ProdutoRepository;
import com.example.aula3.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aula3Application {

	@Bean
	public CommandLineRunner 
		init (@Autowired ProdutoRepository produtoReposiory,
				@Autowired CategoriaProdutoRepository categoriaProdutoRepository){
			return args ->{
				//Inserir categoria
				Categorias categoria = new Categorias(0, "Carro", "Carro bonito");
				categoriaProdutoRepository.inserir(categoria);

				//inserir Produto
				Produtos produto = new Produtos(0, "Honda Civic", 2);
				//Setar o ID da categoria
				produto.setId_categoria(categoria);

				produtoReposiory.inserir(produto);	

			};
		}

	public static void main(String[] args) {
		SpringApplication.run(Aula3Application.class, args);
	}

}
