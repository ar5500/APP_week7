package doctor;
class Doctor {
    private String doctorId;
    private String name;
    private String specialization;
    private double consultationFee;
    private int patientCount;

    public Doctor(String doctorId, String name, String specialization, double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.patientCount = 0;
    }
    public String getDoctorId() { return doctorId; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public double getConsultationFee() { return consultationFee; }
    public void incrementPatientCount() {
        patientCount++;
    }
    public double getTotalFeeCollected() {
        return patientCount * consultationFee;
    }
    public void displayDoctorInfo() {
        System.out.println("\n--- Doctor Details ---");
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Consultation Fee: ₹" + consultationFee);
    }
}

package patient;
class Patient {
    private String patientId;
    private String name;
    private String disease;
    private int age;
    private doctor.Doctor assignedDoctor;

    public Patient(String patientId, String name, String disease, int age) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }
    public String getDisease() { return disease; }
    public void assignDoctor(doctor.Doctor doctor) {
        this.assignedDoctor = doctor;
        doctor.incrementPatientCount();
    }

    public void displayPatientInfo() {
        System.out.println("\n--- Patient Details ---");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Disease: " + disease);
        System.out.println("Age: " + age);
        if (assignedDoctor != null) {
            System.out.println("\nTreated by Doctor:");
            assignedDoctor.displayDoctorInfo();
        }
    }
}
public class HospitalManagementSystem {
    public static void main(String[] args) {
        doctor.Doctor d1 = new doctor.Doctor("D101", "Dr. Meera", "Cardiology", 800);
        doctor.Doctor d2 = new doctor.Doctor("D102", "Dr. Arjun", "Dermatology", 500);

        patient.Patient p1 = new patient.Patient("P201", "Ravi Kumar", "Heart Disease", 45);
        patient.Patient p2 = new patient.Patient("P202", "Sneha", "Skin Allergy", 28);
        patient.Patient p3 = new patient.Patient("P203", "Karan", "Heart Pain", 50);

        if (p1.getDisease().toLowerCase().contains("heart")) p1.assignDoctor(d1);
        else p1.assignDoctor(d2);

        if (p2.getDisease().toLowerCase().contains("skin")) p2.assignDoctor(d2);
        else p2.assignDoctor(d1);

        if (p3.getDisease().toLowerCase().contains("heart")) p3.assignDoctor(d1);
        else p3.assignDoctor(d2);

        p1.displayPatientInfo();
        p2.displayPatientInfo();
        p3.displayPatientInfo();

        System.out.println("\n=== Total Consultation Fees Collected ===");
        System.out.println(d1.getName() + ": ₹" + d1.getTotalFeeCollected());
        System.out.println(d2.getName() + ": ₹" + d2.getTotalFeeCollected());
    }
}
