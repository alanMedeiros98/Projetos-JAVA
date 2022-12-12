package br.com.senai;

import javax.swing.JOptionPane;

import br.com.senai.excecoes.CampoInvalidoException;
import br.com.senai.excecoes.CampoObrigatorioException;
import br.com.senai.excecoes.LimiteAtingidoException;
import br.com.senai.pojo.Estudante;
import br.com.senai.pojo.Fiscal;
import br.com.senai.sistema.SistemaDeRegistro;

public class Principal {

	public static void main(String[] args) {
		
		try {

			Fiscal fiscal = new Fiscal(1, "João da Silva", "00590028911", "75890");

			Estudante estudante1 = new Estudante(2, "Joaquim Menezes", "00210074112");

			Estudante estudante2 = new Estudante(2, "Gerusa Soares", "00440074113");

			SistemaDeRegistro sistema = new SistemaDeRegistro();

			sistema.registrar(fiscal);

			sistema.registrar(estudante1);

			sistema.registrar(estudante2);

		}catch (LimiteAtingidoException lae) {
			JOptionPane.showMessageDialog(null, lae.getMessage());
		}catch (CampoInvalidoException cie) {
			JOptionPane.showMessageDialog(null, cie.getMessage());
		}catch (CampoObrigatorioException coe) {
			JOptionPane.showMessageDialog(null, coe.getMessage());
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

}
