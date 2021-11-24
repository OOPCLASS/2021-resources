package ro.utcluj;

public class StudentNotFoundException extends Error {

  enum ThirdPartySystem {
    LIBRARY, UNIVERSITY, TOWN_HALL
  }
  private ThirdPartySystem thirdPartySystem;

  public StudentNotFoundException(String message, ThirdPartySystem thirdPartySystem) {
    super(message);
    this.thirdPartySystem = thirdPartySystem;
  }

  public ThirdPartySystem getThirdPartySystem() {
    return thirdPartySystem;
  }

  public void setThirdPartySystem(ThirdPartySystem thirdPartySystem) {
    this.thirdPartySystem = thirdPartySystem;
  }
}
