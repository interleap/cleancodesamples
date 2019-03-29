package co.interleap.samples.functions.stringbuilderreport;

public class AccountService {

  public String createReport(){
    StringBuilder stringBuilder = new StringBuilder();
    createHeader(stringBuilder);
    createBody(stringBuilder);
    createFooter(stringBuilder);
    return stringBuilder.toString();
  }

  private void createFooter(StringBuilder stringBuilder) {
    stringBuilder.append("footer line 1");
    stringBuilder.append("footer line 2");
  }

  private void createBody(StringBuilder stringBuilder) {
    stringBuilder.append("body line 1");
    stringBuilder.append("body line 2");
  }

  private void createHeader(StringBuilder stringBuilder) {
    stringBuilder.append("header line 1");
  }
}
