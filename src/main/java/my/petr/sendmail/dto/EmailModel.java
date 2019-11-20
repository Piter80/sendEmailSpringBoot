package my.petr.sendmail.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailModel {

  private String subject;
  private String message;
  private String recipientEmail;
}
