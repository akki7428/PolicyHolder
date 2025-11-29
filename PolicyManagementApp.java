import java.util.ArrayList;
import java.util.List;

class PolicyHolder 
{
    private String policyId;
    private String name;
    private double investmentAmount;
    private int yearsInForce;

    public PolicyHolder(String policyId, String name, double investmentAmount, int yearsInForce)
    {
        this.policyId = policyId;
        this.name = name;
        this.investmentAmount = investmentAmount;
        this.yearsInForce = yearsInForce;
    }
    public String getPolicyId()
    {
        return policyId;
    }
    public void setPolicyId(String policyId) 
    {
        this.policyId = policyId;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public double getInvestmentAmount() 
    {
        return investmentAmount;
    }
    public void setInvestmentAmount(double investmentAmount) 
    {
        this.investmentAmount = investmentAmount;
    }
    public int getYearsInForce() 
    {
        return yearsInForce;
    }
    public void setYearsInForce(int yearsInForce) 
    {
        this.yearsInForce = yearsInForce;
    }
   
    public String toString() 
    {
        return "ID: " + policyId + " | Name: " + name + " | Amount: " + investmentAmount + " | Years: " + yearsInForce;
    }
}
public class PolicyManagementApp 
{
    public static void main(String[] args) 
    {
        List<PolicyHolder> policyList = new ArrayList<>();
        policyList.add(new PolicyHolder("P001", "Alok", 50000, 5));
        policyList.add(new PolicyHolder("P002", "AKKi", 150000, 3));
        policyList.add(new PolicyHolder("P003", "Vansh", 200000, 10)); 
        policyList.add(new PolicyHolder("P004", "nikhil", 80000, 2));
        System.out.println("All Policy Holders & Maturity Calculations");
        for (PolicyHolder holder : policyList) 
        {
            double maturityVal = calculateMaturityValue(holder.getInvestmentAmount(), holder.getYearsInForce());
            System.out.println(holder.getName() + " -> Current: " + holder.getInvestmentAmount() + 
                               ", Maturity Value: " + String.format("%.2f", maturityVal));
        }
        System.out.println("\n High Value Policies (> 1 Lakh)");
        findHighValuePolicy(policyList);
    }
    public static double calculateMaturityValue(double investmentAmount, int yearsInForce) {
        double rate = 0.08;
        return investmentAmount * Math.pow((1 + rate),yearsInForce);
    }
    public static void findHighValuePolicy(List<PolicyHolder> policies) {
        boolean found = false;
        for (PolicyHolder holder : policies) 
        {
            if (holder.getInvestmentAmount() > 100000) 
            {
                System.out.println(holder.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No high value policies found.");
        }
    }
}