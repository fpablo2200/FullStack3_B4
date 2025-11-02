package com.example.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaApplication {

	public static void main(String[] args) {
		// Ensure the Oracle JDBC driver can find the wallet (TNS_ADMIN)
		String walletDir = "C:/Users/Frozx/Desktop/CarpetaU/Bimestre4/clinica/Wallet_WYX2SREW33COOZAE";
		System.setProperty("oracle.net.tns_admin", walletDir);
		System.setProperty("oracle.net.wallet_location", "(SOURCE=(METHOD=FILE)(METHOD_DATA=(DIRECTORY=" + walletDir + ")))" );
		
		SpringApplication.run(ClinicaApplication.class, args);
	}

}
