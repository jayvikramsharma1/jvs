package uk.co.news.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import uk.co.news.main.MainApp;
import uk.co.news.methode.automation.utils.AwesomeIcons;
import uk.co.news.methode.automation.utils.XMLFileReader;;

public class GeneralSettingsController implements Initializable {
	Logger logger = Logger.getLogger(GeneralSettingsController.class);

	@FXML
	private ComboBox<String> settingsChannel;
	@FXML
	private ComboBox<String> settingsTitle;
	@FXML
	private ComboBox<String> settingsEnviornment;
	@FXML
	private TextField settingDevUserName;
	@FXML
	private TextField settingDevPassword;
	@FXML
	private TextField settingSIUserName;
	@FXML
	private TextField settingSIPassword;
	@FXML
	private TextField settingStageUserName;
	@FXML
	private TextField settingStagePassword;
	@FXML
	private TextField settingUATUserName;
	@FXML
	private TextField settingUATPassword;
	@FXML
	private TextField settingProdUserName;
	@FXML
	private TextField settingProdPassword;
	@FXML
	private TextField settingMethodePath;
	@FXML
	private TextField settingsS3Url;
	@FXML
	private TextField settingsArticleFeedPath;
	@FXML
	private TextField settingsSlotFeedPath;
	@FXML
	private TextField settingsBookFeedPath;
	@FXML
	private TextField settingsSectionFeedPath;
	@FXML
	private TextField settingsEditionFeedPath;
	@FXML
	private TextField settingsImageFeedPath;
	@FXML
	private TextField settingsAritcleMetadataFeedPath;
	@FXML
	private TextField settingsSlotMetadataFeedPath;
	@FXML
	private TextField settingsImageMetadataFeedPath;
	@FXML
	private TextField settingsImagePositionalFeedPath;
	@FXML
	private Button settingsSave;
	@FXML
	private Button settingsCancel;
	@FXML
	private TextField settingsS3BucketName;
	@FXML
	private PasswordField settingsS3ApiKey;
	@FXML
	private PasswordField settingsS3ApiSecret;
	@FXML
	private TextField settingsS3MediaPath;
	@FXML
	private TextField settingsS3ReportPath;
	@FXML
	private Button settingDevUserNameEdit;
	@FXML
	private Button settingDevPasswordEdit;
	@FXML
	private Button settingSIUserNameEdit;
	@FXML
	private Button settingSIPasswordEdit;
	@FXML
	private Button settingStageUserNameEdit;
	@FXML
	private Button settingStagePasswordEdit;
	@FXML
	private Button settingUATUserNameEdit;
	@FXML
	private Button settingUATPasswordEdit;
	@FXML
	private Button settingProdUserNameEdit;
	@FXML
	private Button settingProdPasswordEdit;
	@FXML
	private Button settingMethodePathEdit;
	@FXML
	private Button settingsS3UrlEdit;
	@FXML
	private Button settingsArticleFeedPathEdit;
	@FXML
	private Button settingsSlotFeedPathEdit;
	@FXML
	private Button settingsBookFeedPathEdit;
	@FXML
	private Button settingsSectionFeedPathEdit;
	@FXML
	private Button settingsEditionFeedPathEdit;
	@FXML
	private Button settingsImageFeedPathEdit;
	@FXML
	private Button settingsAritcleMetadataFeedPathEdit;
	@FXML
	private Button settingsSlotMetadataFeedPathEdit;
	@FXML
	private Button settingsImageMetadataFeedPathEdit;
	@FXML
	private Button settingsImagePositionalFeedPathEdit;
	@FXML
	private Button settingsS3BucketNameEdit;
	@FXML
	private Button settingsS3ApiKeyEdit;
	@FXML
	private Button settingsS3ApiSecretEdit;
	@FXML
	private Button settingsS3MediaPathEdit;
	@FXML
	private Button settingsS3ReportPathEdit;
	private static String envConfig = "config/env.xml";
	private static String templateFile = "template/env.template";

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		settingsChannel.getItems().addAll(MainApp.configProperties.getProperty("application.channel.print"), MainApp.configProperties.getProperty("application.channel.tablet"), MainApp.configProperties.getProperty("application.channel.digital"));
		settingsTitle.getItems().addAll(MainApp.configProperties.getProperty("application.title.times"), MainApp.configProperties.getProperty("application.title.sundaytimes"), MainApp.configProperties.getProperty("application.title.sun"));
		settingsEnviornment.getItems().addAll(MainApp.configProperties.getProperty("application.enviornment.dev"), MainApp.configProperties.getProperty("application.enviornment.si"), MainApp.configProperties.getProperty("application.enviornment.stage"), MainApp.configProperties.getProperty("application.enviornment.uat"), MainApp.configProperties.getProperty("application.enviornment.prod"));
		setCurrentSettingsToScene();
		settingsSave.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try {
					saveEditedSettings();
					setAllFieldsDisabled();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		settingsCancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ParentWindowController parentWindowController = MainApp.parentWindowController;
				parentWindowController.homePage(MainApp.configProperties.getProperty("application.title"),
						MainApp.allViews);
			}
		});
		setAllFieldsDisabled();
		setEditIconToButtons();
		enableFieldsOnClickOnEditButton();
		setToolTips();

	}

	public void setUserCredentials(Document doc, String nodeName, TextField userNameTextField,
			TextField PasswordTextField) {
		NamedNodeMap devNode = doc.getElementsByTagName(nodeName).item(0).getAttributes();
		userNameTextField.setText(devNode.getNamedItem("username").getNodeValue());
		PasswordTextField.setText(devNode.getNamedItem("password").getNodeValue());
	}

	public void setCurrentSettingsToScene() {
		String envConfigurationFile = MainApp.configProperties.getProperty("base.autocam.dir") + envConfig;
		Document doc = XMLFileReader.getXMLFile(envConfigurationFile);

		NamedNodeMap defaultSettingNode = doc.getElementsByTagName("default").item(0).getAttributes();
		settingsChannel.setPromptText(defaultSettingNode.getNamedItem("channel").getNodeValue());
		settingsTitle.setPromptText(defaultSettingNode.getNamedItem("title").getNodeValue());
		settingsEnviornment.setPromptText(defaultSettingNode.getNamedItem("env").getNodeValue());

		setUserCredentials(doc, "dev", settingDevUserName, settingDevPassword);
		setUserCredentials(doc, "si", settingSIUserName, settingSIPassword);
		setUserCredentials(doc, "stage", settingStageUserName, settingStagePassword);
		setUserCredentials(doc, "uat", settingUATUserName, settingUATPassword);
		setUserCredentials(doc, "prod", settingProdUserName, settingProdPassword);

		settingMethodePath.setText(
				doc.getElementsByTagName("methode").item(0).getAttributes().getNamedItem("path").getNodeValue());
		settingsS3Url
				.setText(doc.getElementsByTagName("s3URL").item(0).getAttributes().getNamedItem("path").getNodeValue());
		settingsArticleFeedPath.setText(
				doc.getElementsByTagName("articleFeed").item(0).getAttributes().getNamedItem("path").getNodeValue());
		settingsSlotFeedPath.setText(
				doc.getElementsByTagName("slotFeed").item(0).getAttributes().getNamedItem("path").getNodeValue());
		settingsBookFeedPath.setText(
				doc.getElementsByTagName("bookFeed").item(0).getAttributes().getNamedItem("path").getNodeValue());
		settingsSectionFeedPath.setText(
				doc.getElementsByTagName("sectionFeed").item(0).getAttributes().getNamedItem("path").getNodeValue());
		settingsEditionFeedPath.setText(
				doc.getElementsByTagName("editionFeed").item(0).getAttributes().getNamedItem("path").getNodeValue());
		settingsImageFeedPath.setText(
				doc.getElementsByTagName("imageFeed").item(0).getAttributes().getNamedItem("path").getNodeValue());
		settingsAritcleMetadataFeedPath.setText(doc.getElementsByTagName("articleMetadataFeed").item(0).getAttributes()
				.getNamedItem("path").getNodeValue());
		settingsSlotMetadataFeedPath.setText(doc.getElementsByTagName("slotMetadataFeed").item(0).getAttributes()
				.getNamedItem("path").getNodeValue());
		settingsImageMetadataFeedPath.setText(doc.getElementsByTagName("imageMetadataFeed").item(0).getAttributes()
				.getNamedItem("path").getNodeValue());
		settingsImagePositionalFeedPath.setText(doc.getElementsByTagName("imagePositionalFeed").item(0).getAttributes()
				.getNamedItem("path").getNodeValue());
		settingsS3BucketName.setText(doc.getElementsByTagName("s3Bucket").item(0).getTextContent());
		settingsS3ApiKey.setText(doc.getElementsByTagName("s3ApiKey").item(0).getTextContent());
		settingsS3ApiSecret.setText(doc.getElementsByTagName("s3ApiSecret").item(0).getTextContent());
		settingsS3MediaPath.setText(doc.getElementsByTagName("s3MediaPath").item(0).getTextContent());
		settingsS3ReportPath.setText(doc.getElementsByTagName("s3ReportPath").item(0).getTextContent());
	}

	public void saveEditedSettings() throws IOException {
		Alert confirmationAlert = new Alert(AlertType.CONFIRMATION, "Do you really want to save modified settings ?",
				ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
		Stage stage = (Stage) confirmationAlert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(getClass().getClassLoader().getResourceAsStream("ic.png")));
		confirmationAlert.showAndWait();
		if (confirmationAlert.getResult() == ButtonType.YES) {
			logger.debug("Yes");
			Path envTemplatePath = Paths.get(MainApp.configProperties.getProperty("base.autocam.dir") + templateFile);
			logger.debug(envTemplatePath.toAbsolutePath());
			String envTemplateContent = new String(Files.readAllBytes(envTemplatePath));
			logger.debug(envTemplateContent);
			String formatedEnvTemplates = String.format(envTemplateContent, getContentToFormateString());
			logger.debug(envTemplateContent);
			Files.write(Paths.get(MainApp.configProperties.getProperty("base.autocam.dir") + envConfig),
					formatedEnvTemplates.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
		}

	}

	public String[] getContentToFormateString() {
		String[] args = new String[30];
		args[0] = settingsChannel.getPromptText();
		args[1] = settingsTitle.getPromptText();
		args[2] = settingsEnviornment.getPromptText();
		args[3] = settingDevUserName.getText();
		args[4] = settingDevPassword.getText();
		args[5] = settingSIUserName.getText();
		args[6] = settingSIPassword.getText();
		args[7] = settingStageUserName.getText();
		args[8] = settingStagePassword.getText();
		args[9] = settingUATUserName.getText();
		args[10] = settingUATPassword.getText();
		args[11] = settingProdUserName.getText();
		args[12] = settingProdPassword.getText();
		args[13] = settingMethodePath.getText();
		args[14] = settingsS3Url.getText();
		args[15] = settingsS3BucketName.getText();
		args[16] = settingsS3ApiKey.getText();
		args[17] = settingsS3ApiSecret.getText();
		args[18] = settingsS3MediaPath.getText();
		args[19] = settingsS3ReportPath.getText();
		args[20] = settingsArticleFeedPath.getText();
		args[21] = settingsSlotFeedPath.getText();
		args[22] = settingsBookFeedPath.getText();
		args[23] = settingsSectionFeedPath.getText();
		args[24] = settingsEditionFeedPath.getText();
		args[25] = settingsImageFeedPath.getText();
		args[26] = settingsAritcleMetadataFeedPath.getText();
		args[27] = settingsSlotMetadataFeedPath.getText();
		args[28] = settingsImageMetadataFeedPath.getText();
		args[29] = settingsImagePositionalFeedPath.getText();
		return args;
	}

	public void setEditIconToButtons() {
		 List<Button> editButtons = new ArrayList<>();
		 editButtons.add(settingDevUserNameEdit);
		 editButtons.add(settingDevPasswordEdit);
		 editButtons.add(settingSIUserNameEdit);
		 editButtons.add(settingSIPasswordEdit);
		 editButtons.add(settingStageUserNameEdit);
		 editButtons.add(settingStagePasswordEdit);
		 editButtons.add(settingUATUserNameEdit);
		 editButtons.add(settingUATPasswordEdit);
		 editButtons.add(settingProdUserNameEdit);
		 editButtons.add(settingProdPasswordEdit);
		 editButtons.add(settingMethodePathEdit);
		 editButtons.add(settingsS3UrlEdit);
		 editButtons.add(settingsArticleFeedPathEdit);
		 editButtons.add(settingsSlotFeedPathEdit);
		 editButtons.add(settingsBookFeedPathEdit);
		 editButtons.add(settingsSectionFeedPathEdit);
		 editButtons.add(settingsEditionFeedPathEdit);
		 editButtons.add(settingsImageFeedPathEdit);
		 editButtons.add(settingsAritcleMetadataFeedPathEdit);
		 editButtons.add(settingsSlotMetadataFeedPathEdit);
		 editButtons.add(settingsImageMetadataFeedPathEdit);
		 editButtons.add(settingsImagePositionalFeedPathEdit);
		 editButtons.add(settingsS3BucketNameEdit);
		 editButtons.add(settingsS3ApiKeyEdit);
		 editButtons.add(settingsS3ApiSecretEdit);
		 editButtons.add(settingsS3MediaPathEdit);
		 editButtons.add(settingsS3ReportPathEdit);
		 addFontAwesomeToEditButton(editButtons);
		 
	}

	public void setAllFieldsDisabled() {
		settingDevUserName.setEditable(false);
		settingDevPassword.setEditable(false);
		settingSIUserName.setEditable(false);
		settingSIPassword.setEditable(false);
		settingStageUserName.setEditable(false);
		settingStagePassword.setEditable(false);
		settingUATUserName.setEditable(false);
		settingUATPassword.setEditable(false);
		settingProdUserName.setEditable(false);
		settingProdPassword.setEditable(false);
		settingMethodePath.setEditable(false);
		settingsS3Url.setEditable(false);
		settingsArticleFeedPath.setEditable(false);
		settingsSlotFeedPath.setEditable(false);
		settingsBookFeedPath.setEditable(false);
		settingsSectionFeedPath.setEditable(false);
		settingsEditionFeedPath.setEditable(false);
		settingsImageFeedPath.setEditable(false);
		settingsAritcleMetadataFeedPath.setEditable(false);
		settingsSlotMetadataFeedPath.setEditable(false);
		settingsImageMetadataFeedPath.setEditable(false);
		settingsImagePositionalFeedPath.setEditable(false);
		settingsS3BucketName.setEditable(false);
		settingsS3ApiKey.setEditable(false);
		settingsS3ApiSecret.setEditable(false);
		settingsS3MediaPath.setEditable(false);
		settingsS3ReportPath.setEditable(false);
	}

	public void enableFieldsOnClickOnEditButton() {
		settingDevUserNameEdit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				settingDevUserName.setEditable(true);
			}
		});
		settingDevPasswordEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingDevPassword.setEditable(true);
			}
		});
		settingSIUserNameEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingSIUserName.setEditable(true);
			}
		});
		settingSIPasswordEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingSIPassword.setEditable(true);
			}
		});
		settingStageUserNameEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingStageUserName.setEditable(true);
			}
		});
		settingStagePasswordEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingStagePassword.setEditable(true);
			}
		});
		settingUATUserNameEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingUATUserName.setEditable(true);
			}
		});
		settingUATPasswordEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingUATPassword.setEditable(true);
			}
		});
		settingProdUserNameEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingProdUserName.setEditable(true);
			}
		});
		settingProdPasswordEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingProdPassword.setEditable(true);
			}
		});
		settingMethodePathEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingMethodePath.setEditable(true);
			}
		});
		settingsS3UrlEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsS3Url.setEditable(true);
			}
		});
		settingsArticleFeedPathEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsArticleFeedPath.setEditable(true);
			}
		});
		settingsSlotFeedPathEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsSlotFeedPath.setEditable(true);
			}
		});
		settingsBookFeedPathEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsBookFeedPath.setEditable(true);
			}
		});
		settingsSectionFeedPathEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsSectionFeedPath.setEditable(true);
			}
		});
		settingsEditionFeedPathEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsEditionFeedPath.setEditable(true);
			}
		});
		settingsImageFeedPathEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsImageFeedPath.setEditable(true);
			}
		});
		settingsAritcleMetadataFeedPathEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsAritcleMetadataFeedPath.setEditable(true);
			}
		});
		settingsSlotMetadataFeedPathEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsSlotMetadataFeedPath.setEditable(true);
			}
		});
		settingsImageMetadataFeedPathEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsImageMetadataFeedPath.setEditable(true);
			}
		});
		settingsImagePositionalFeedPathEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsImagePositionalFeedPath.setEditable(true);
			}
		});
		settingsS3BucketNameEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsS3BucketName.setEditable(true);
			}
		});
		settingsS3ApiKeyEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsS3ApiKey.setEditable(true);
			}
		});
		settingsS3ApiSecretEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsS3ApiSecret.setEditable(true);
			}
		});
		settingsS3MediaPathEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsS3MediaPath.setEditable(true);
			}
		});
		settingsS3ReportPathEdit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				settingsS3ReportPath.setEditable(true);
			}
		});
	}

	private void setToolTips() {
		settingDevUserName.setTooltip(toolTipFactory(settingDevUserName.getText()));
		settingDevPassword.setTooltip(toolTipFactory(settingDevPassword.getText()));
		settingSIUserName.setTooltip(toolTipFactory(settingSIUserName.getText()));
		settingSIPassword.setTooltip(toolTipFactory(settingSIPassword.getText()));
		settingStageUserName.setTooltip(toolTipFactory(settingStageUserName.getText()));
		settingStagePassword.setTooltip(toolTipFactory(settingStagePassword.getText()));
		settingUATUserName.setTooltip(toolTipFactory(settingUATUserName.getText()));
		settingUATPassword.setTooltip(toolTipFactory(settingUATPassword.getText()));
		settingProdUserName.setTooltip(toolTipFactory(settingProdUserName.getText()));
		settingProdPassword.setTooltip(toolTipFactory(settingProdPassword.getText()));
		settingMethodePath.setTooltip(toolTipFactory(settingMethodePath.getText()));
		settingsS3Url.setTooltip(toolTipFactory(settingsS3Url.getText()));
		settingsArticleFeedPath.setTooltip(toolTipFactory(settingsArticleFeedPath.getText()));
		settingsSlotFeedPath.setTooltip(toolTipFactory(settingsSlotFeedPath.getText()));
		settingsBookFeedPath.setTooltip(toolTipFactory(settingsBookFeedPath.getText()));
		settingsSectionFeedPath.setTooltip(toolTipFactory(settingsSectionFeedPath.getText()));
		settingsEditionFeedPath.setTooltip(toolTipFactory(settingsEditionFeedPath.getText()));
		settingsImageFeedPath.setTooltip(toolTipFactory(settingsImageFeedPath.getText()));
		settingsAritcleMetadataFeedPath.setTooltip(toolTipFactory(settingsAritcleMetadataFeedPath.getText()));
		settingsSlotMetadataFeedPath.setTooltip(toolTipFactory(settingsSlotMetadataFeedPath.getText()));
		settingsImageMetadataFeedPath.setTooltip(toolTipFactory(settingsImageMetadataFeedPath.getText()));
		settingsImagePositionalFeedPath.setTooltip(toolTipFactory(settingsImagePositionalFeedPath.getText()));
		settingsS3BucketName.setTooltip(toolTipFactory(settingsS3BucketName.getText()));
		// settingsS3ApiKey.setTooltip(toolTipFactory(settingsS3ApiKey.getText()));
		// settingsS3ApiSecret.setTooltip(toolTipFactory(settingsS3ApiSecret.getText()));
		settingsS3MediaPath.setTooltip(toolTipFactory(settingsS3MediaPath.getText()));
		settingsS3ReportPath.setTooltip(toolTipFactory(settingsS3ReportPath.getText()));
	}

	private Tooltip toolTipFactory(String toolTipText) {
		Tooltip toolTip = new Tooltip();
		toolTip.setText(toolTipText);
		return toolTip;
	}
	
	private void addFontAwesomeToEditButton(List<Button> buttons) {
		Font font = MainApp.fontAwesome;
		for(Button editButton : buttons) {
			editButton.setFont(font);
			editButton.setText(AwesomeIcons.ICON_PENCIL);
		}
		
	}
}
