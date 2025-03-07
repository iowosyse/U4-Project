package Project;

import Controllers.Permissions;

public class Admin extends User{
    private boolean isSuperAdmin;

    public Admin(){

    }

    public Admin(boolean inQuarantine) {
        super(inQuarantine);
        userType = "Admin";
        setPermissionsString();
    }

    public Admin(Permissions a, Permissions b, Permissions c) {
        super(a);
        permissions[1] = b;
        permissions[2] = c;
        userType = "Admin";
        setPermissionsString();
    }

    public Admin(Permissions a, Permissions b) {
        super(a);
        permissions[1] = b;
        userType = "Admin";
        setPermissionsString();
    }

    public Admin(Permissions a) {
        super(a);
        userType = "Admin";
        setPermissionsString();
    }

    public boolean isSuperAdmin() {
        return isSuperAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        isSuperAdmin = superAdmin;
    }
}
