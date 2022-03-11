package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement firstCard = $$(".list__item").first();
    private SelenideElement secondCard = $$(".list__item").last();
    private SelenideElement reload = $("[data-test-id=action-reload]");
    private SelenideElement firstCardButton = $$("[data-test-id=action-deposit]").first();
    private SelenideElement secondCardButton = $$("[data-test-id=action-deposit]").last();
    private String balanceStart = "баланс: ";
    private String balanceFinish = " р.";

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public TransferPage firstCardButton() {
        firstCardButton.click();
        return new TransferPage();
    }

    public TransferPage secondCardButton() {
        secondCardButton.click();
        return new TransferPage();
    }

    public DashboardPage reloadPage() {
        reload.click();
        return new DashboardPage();
    }

    public int getFirstCardBalance() {
        val text = firstCard.text();
        return extractBalanceCard(text);
    }


    public int getSecondCardBalance() {
        val text = secondCard.text();
        return extractBalanceCard(text);
    }

    private int extractBalanceCard(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }


}
