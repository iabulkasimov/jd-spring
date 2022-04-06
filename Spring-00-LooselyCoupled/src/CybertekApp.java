import service.FullTimeMentor;
import service.MentorAccount;
import service.PartTimeMentor;

public class CybertekApp {
    public static void main(String[] args) {

        FullTimeMentor fullTimeMentor = new FullTimeMentor();
        MentorAccount mentorAccount = new MentorAccount(fullTimeMentor);
        mentorAccount.manageAccount();

        PartTimeMentor partTimeMentor = new PartTimeMentor();
        MentorAccount mentorAccount1 = new MentorAccount(partTimeMentor);
        mentorAccount1.manageAccount();

    }
}
