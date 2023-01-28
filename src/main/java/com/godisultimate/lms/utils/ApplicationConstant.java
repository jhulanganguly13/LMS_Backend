package com.godisultimate.lms.utils;

import java.io.File;

public class ApplicationConstant {

	public static final double SERVER_VERSION = 1.6;

	// ***************** Image cloud upload String files **************//

	// Developer and testing
	public static final String bucketName = "temp_file_for_testing";
	public static final String path = "/opt/tomcat/webapps/wiselap-0.0.1-Testing/";
	public static final String imageUploadAuthenticationFilePath = path + "serviceapps-806b6-91e6650006f3.json";

	public static final String wiselapImageLogoPath = path + "wiselapLogo.png";

	public static final String booklet_barcode_path = path + "/WEB-INF/bookletbarcode.pdf";
	public static final String customer_barcode_path = path + "/WEB-INF/customerbarcode.pdf";

	// public static final String iOSCertificate =
	// "/home/piyush/git/developer/wiseerp/src/main/webapp/CertificatesWithPass.p12";
	public static final String iOSCertificate = path + "CertificatesWithPass.p12";

	// Production
	// public static final String bucketName = "wiselap_product";
	// public static final String imageUploadAuthenticationFilePath =
	// "/opt/tomcat/webapps/wiselap-0.0.1-External/WiseBillMilkman-2cadff1fb5ba.json";
	// public static final String booklet_barcode_path =
	// "/opt/tomcat/webapps/wiselap-0.0.1-External/WEB-INF/bookletbarcode.pdf";
	// public static final String customer_barcode_path =
	// "/opt/tomcat/webapps/wiselap-0.0.1-External/WEB-INF/customerbarcode.pdf";

	// Save the uploaded file to this folder
	// public static final String UPLOADED_FOLDER = "/home/piyush/TEMP/";

	public static final String WISELAP_PACKAGE_NAME = "WISELAP";
	public static final String PENCHMILK_PACKAGE_NAME = "com.penchmilk";
	public static final String SAIBAZAR_PACKAGE_NAME = "com.saibazar";
	public static final String PENCHMILK_ShopDetailsId = "2325";
	public static final String SAIBAZAR_ShopDetailsId = "2257";
	/**********
	 * Default Product CSV File Upload Path
	 */

	public static final String default_product_csv_file_path = "/opt/tomcat/webapps/wiselap-0.0.1-Testing/WEB-INF/";

	// public static final String default_product_csv_file_path=
	// "/home/wiselapdipti/BITS_HOME/";

	public static final String default_product_csv_file_name = "default_product.csv";

	/***********/
	public static final String SHOP_DATA_DIR = File.separator + "home" + File.separator + "doc" + File.separator
			+ "Individuals";


	//below variables are used for lms-app-apis
	public static final String user_sequence = "user_sequence";
	public static final String raffle_sequence = "raffle_sequence";
	public static final String raffle_group_sequence = "raffle_group_sequence";
	public static final String purchase_sequence = "purchase_sequence";
	public static final String prch_sequence = "prch_sequence";
	public static final String prch_dtls_sequence = "prch_dtls_sequence";
	public static final String rflStk_sequence = "rflStk_sequence";
	public static final String dsph_sequence = "dsph_sequence";
	public static final String dsph_dtls_sequence = "dsph_dtls_sequence";
	public static final String user_role_sequence = "user_role_sequence";
	public static final String adv_return_sequence = "adv_return_sequence";
	public static final String adv_return_dtls_sequence = "adv_return_dtls_sequence";
	

}
