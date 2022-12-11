/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.helper;
import Enterprise.SystemAdminLeftPanel;
import ui.SystemAdminPanel.SystemAdmin_Dashboard;
import java.awt.Component;
import model.Person.Person;
import ui.InsuranceManagment.TravelInsuranceAdmin_Dashboard;
import ui.SystemAdminPanel.SystemAdmin_Dashboard;
import ui.sysAdminDashboard.SysAdminHomePanel;
import ui.userdashboard.Dashboard;
import ui.userdashboard.HomePanel;
import ui.userdashboard.UserLeftPanel;
/**
 *
 * @author slenk
 */
public class GetRoleSpecificDashboard {
    
    public static Component getLeftPanel(Person person, Dashboard dashboard) {
        Component component = null;
        switch (person.getRole()) {
            
            case "PASSENGER":
                component = new UserLeftPanel(dashboard);
                break;
            default:
                break;
        }
        return component;
    }
    
    public static Component getRightPanel(Person person, Dashboard dashboard) {
        Component component = null;
        switch (person.getRole()) {
            
            case "PASSENGER":
                component = new HomePanel();
                break;
            default:
                break;
        }
        return component;
    }
    
    public static void getDashboard(Person person) {
        String role = person.getRole();
        
        switch (role) {
            case "SYSTEM_ADMIN":
                SystemAdmin_Dashboard systemAdminDashboard = 
                        new SystemAdmin_Dashboard();
                systemAdminDashboard.setVisible(true);  
                break;
                
            case "INSURANCE_ADMIN":
                System.out.println("ias");
                TravelInsuranceAdmin_Dashboard ia_dash = new 
                    TravelInsuranceAdmin_Dashboard();
                ia_dash.setVisible(true);
                break;
            
            default:
                throw new AssertionError();
        }
    }
    
}
