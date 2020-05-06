package com.test.springbootproject.configuration;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

@Configuration
@PropertySource("classpath:mail.properties")
@Validated
public class MailProperties {

    @NotNull
    private String hostname;

    @Min(1000)
    private int port;

    @NotNull
    private String from;

    @NotNull
    private List<String> recipients;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

	@Override
	public String toString() {
		return "MailProperties [hostname=" + hostname + ", port=" + port + ", from=" + from + ", recipients="
				+ recipients + "]";
	}
    
    
}