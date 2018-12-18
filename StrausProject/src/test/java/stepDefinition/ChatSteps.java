package stepDefinition;

import com.endava.straus.atf.common.action.Screenshot;
import comonSteps.BaseStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import com.endava.straus.atf.page.ChatAdditionalPage;
import testContext.TestContext;

import static org.hamcrest.CoreMatchers.is;
import static utilities.Logger.assertThat;

public class ChatSteps extends BaseStep {
    public ChatSteps(TestContext context) {
        super(context);
    }

    @When("^user accesses Help iframe$")
    public void userAccessesHelpIframe() {
        page = utilities.getPageByName("ChatAdditional");
        ChatAdditionalPage chatAdditional = (ChatAdditionalPage) page;
        chatAdditional.switchFrameToHelp(chatAdditional.helpButton);
        chatAdditional.clickHelpButton();
        chatAdditional.switchFrameToHelp(chatAdditional.greetingText);
        assertThat("User switched to Help iframe", chatAdditional.getGreetingText(), is("“If you’re afraid of butter, use cream.” - Julia Child"));
    }

    @And("^user fills in only ([^\"]*)$")
    public void userProvidesOnly(String arg0) {
        page = utilities.getPageByName("ChatAdditional");
        ChatAdditionalPage chatAdditional = (ChatAdditionalPage) page;
        switch (arg0) {
            case "Name":
                chatAdditional.clearField(chatAdditional.nameInputHelp);
                chatAdditional.typePhoneNumber("123456789");
                chatAdditional.clickSubmitButton();
                Screenshot.takeScreenshot(driver, (WebElement) chatAdditional.nameErrorMsg, flag);
                assertThat("User is warned that Phone field is mandatory", chatAdditional.getText(chatAdditional.nameErrorMsg), is("Name must be provided."));
                break;
            case "Phone":
                chatAdditional.clearField(chatAdditional.phoneInputHelp);
                chatAdditional.typeUserName("test_user");
                chatAdditional.clickSubmitButton();
                Screenshot.takeScreenshot(driver, (WebElement) chatAdditional.phoneErrorMsg, flag);
                assertThat("User is warned that Name field is mandatory", chatAdditional.getText(chatAdditional.phoneErrorMsg), is("Invalid phone number"));
                break;
            case "Credentials":
                chatAdditional.enterCredsForChat("Ion","79216521");
                Screenshot.takeScreenshot(driver, (WebElement) chatAdditional.submitHelp, flag);
                chatAdditional.clickSubmitButton();
                break;

        }
    }

    @And("^user opens chat menu$")
    public void userOpenChatMenu() {
        page = utilities.getPageByName("ChatAdditional");
        ChatAdditionalPage chatAdditional = (ChatAdditionalPage) page;
        Screenshot.takeScreenshot(driver, (WebElement) chatAdditional.navbarDropdown, flag);
        chatAdditional.clickNavbarDropdown();
    }

    @And("^user navigates to ([^\"]*) from chat$")
    public void userNavigatesInChatFrame(String arg0) {
        page = utilities.getPageByName("ChatAdditional");
        ChatAdditionalPage chatAdditional = (ChatAdditionalPage) page;
        switch (arg0) {
            case "EmailTranscript":
                Screenshot.takeScreenshot(driver, (WebElement) chatAdditional.emailTranscript, flag);
                chatAdditional.clickEmailTranscript();
                assertThat("User navigated to e-mail transcript com.endava.straus.atf.page",chatAdditional.getText(chatAdditional.emailTranscriptText),is("Email transcript to:"));
                break;
            case "EndThisChatSession":
                Screenshot.takeScreenshot(driver, (WebElement) chatAdditional.endThisChat, flag);
                chatAdditional.clickEndThisChat();
                chatAdditional.clickSubmitButtonHelp();
            default:
                System.out.println(arg0 + " was not found");
        }
    }

    @And("^user submits email address$")
    public void userSubmitsEmailAddress() {
        page = utilities.getPageByName("ChatAdditional");
        ChatAdditionalPage chatAdditional = (ChatAdditionalPage) page;
        chatAdditional.typeEmail("fivalut@gmail.com");
        chatAdditional.clickSubmitButtonHelp();
    }

    @And("^user sends '([^\"]*)' in chat$")
    public void userSendsInChat(String arg0) {
        page = utilities.getPageByName("ChatAdditional");
        ChatAdditionalPage chatAdditional = (ChatAdditionalPage) page;
        chatAdditional.sendMessages(arg0);
    }
}