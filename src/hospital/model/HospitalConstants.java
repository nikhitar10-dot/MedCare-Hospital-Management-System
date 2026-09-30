package hospital.model;

public final class HospitalConstants {

    // Final class prevents inheritance because this class stores constants.
    private HospitalConstants() {
    }

    public static final String HOSPITAL_NAME =
            "MedCare Hospital";

    public static final double DEFAULT_DISCOUNT =
            5.0;

    public static final int MAX_PATIENT_AGE =
            120;
}