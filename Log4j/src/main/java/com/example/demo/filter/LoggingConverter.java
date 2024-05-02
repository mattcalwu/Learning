package com.example.demo.filter;


import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Plugin(name="LoggingConverter", category = "Converter")
@ConverterKeys({"logMask"})
public class LoggingConverter extends LogEventPatternConverter{

  private static final String EMAIL_PATTERN = "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+";
  private Logger logger = LoggerFactory.getLogger(LoggingConverter.class);

  protected LoggingConverter(String name, String style) {
    super(name, style);
  }

  // This method is used by Log4J's engine. Do not remove it.
  public static LoggingConverter newInstance(final Configuration config, final String[] options) {
    return new LoggingConverter("hideEmails", Thread.currentThread().getName());
  }

  @Override
  public void format(LogEvent event, StringBuilder outputMessage) {
    String messageString = outputMessage.toString();
    outputMessage.delete(0, outputMessage.length());

    outputMessage.append(messageString.replaceAll(EMAIL_PATTERN, "<masked email>"));
  }
}
