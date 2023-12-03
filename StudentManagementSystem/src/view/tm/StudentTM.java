package view.tm;

import javafx.scene.control.Button;

public class StudentTM {
    private String sId;
    private String name;
    private String email;
    private String contact;
    private String address;
    private String nic;
    private Button btn;

    public StudentTM() {
    }

    public StudentTM(String sId, String name, String email, String contact, String address, String nic, Button btn) {
        this.sId = sId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.nic = nic;
        this.btn = btn;
    }

    public String getId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "sId='" + sId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", btn=" + btn +
                '}';
    }
}
