import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class GymGui implements MouseListener, ActionListener
{
    String fpName, fpId, fpLocation, fpGender, fpDOB, fpPhoneNo, fpEmail, fpMembershipDate, fpPersonalTrainer, fpPaidAmount;
    String frName, frId, frLocation, frGender, frDOB, frPhoneNo, frEmail, frMembershipDate, frReferalSource, frPlan;
    int finalRId, finalPId;
    JFrame frame, fileFrame;
    JTextArea fileLabel;
    Font dashboardTitle, subTitle, subLabel,formTitle, formSubTitle, formLabelFont, displayFont;
    ImageIcon icon;
    Cursor pointerCursor;
    JLabel logo;
    
    //initializing dashboard panel element
    JPanel dashboardPanel;
    JLabel dashboardLabel;
    ImageIcon dashIcon;
    JPanel line;
    JLabel addMemberLabel;
    JLabel premiumMember;
    JLabel regularMember;
    JPanel line2;
    JLabel MemberControLabel;
    JLabel activateMembership;
    JLabel deActivateMembership;
    JLabel revertMember;
    JLabel markAttendance;
    JPanel line3;
    JLabel financeManagent;
    JLabel payDueAmount;
    JLabel calculateDiscount;
    JLabel upgradePlan;
    JPanel line4;
    JLabel read;
    JLabel display;
    JLabel readFromFile;
    JLabel saveTofile;

    //inititalizing premium member panel
    JPanel premiumPanel;
    JLabel formAddLabel, premiumAddLabel, basicDetail, pName, pId ,pLocation, pGender, pDOB, contact, pPhoneNo, pEmail, membershipDetail, pMembershipStartDate, pPersonalTrainer, pPaidAmount;
    JTextField pNameTxt, pIdTxt, pLocationTxt, pPhoneNoTxt, pEmailTxt, pPersonalTrainerTxt, pPaidAmountTxt;
    JRadioButton pMale, pFemale;
    ButtonGroup pGroup;
    JComboBox DOByear, DOBmonth, DOBday;
    String DOByearArr[] = {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015",
                            "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026"};
    String DOBmonthArr[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
    String DOBdayArr[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"
                        , "27", "28", "29", "30", "31"};
    JComboBox membershipyear, membershipmonth, membershipday;
    String membershipyearArr[] = DOByearArr;
    String membershipmonthArr[] = DOBmonthArr;
    String membershipdayArr[] = DOBdayArr;
    JPanel pPriceInfo, pPricePanel;
    JLabel pBasicPrice, pStandarrdPrice, pPriceDetail, pPriceButton, pPriceLine;
    JButton pSaveBtn, pClearBtn;

    //inititalizing regular member panel
    JPanel regularPanel;
    JLabel rformAddLabel, regularAddLabel, rbasicDetail,rcontact,rmembershipDetail, rName, rId ,rLocation, rGender, rDOB, rPhoneNo, rEmail, rMembershipStartDate, rReferalSource, rPlan;
    JTextField rNameTxt, rIdTxt, rLocationTxt, rPhoneNoTxt, rEmailTxt, rReferalSourceTxt;
    JRadioButton rMale, rFemale;
    ButtonGroup rGroup; 
    JComboBox rDOByear, rDOBmonth, rDOBday,rmembershipyear, rmembershipmonth, rmembershipday, rPlanBox;
    String rDOByearArr[] = {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015",
                            "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026"};
    String rDOBmonthArr[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
    String rDOBdayArr[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"
                        , "27", "28", "29", "30", "31"};
    String rmembershipyearArr[] = rDOByearArr;
    String rmembershipmonthArr[] = rDOBmonthArr;
    String rmembershipdayArr[] = rDOBdayArr;
    String plan[] = {"Basic", "Standard", "Deluxe"};
    JPanel rPriceInfo, rPricePanel;
    JLabel rBasicPrice, rStandarrdPrice, rDeluxePrice,rPriceDetail, rPriceButton, rPriceLine;
    JButton rSaveBtn, rClearBtn;

    //inititalizing MemberControl panel
    JPanel memberControlPanel, pMemberContainer, rMemberContainer;
    JLabel memberControlLabel, searchLabel, pContainerTitle, rContainerTitle, pContainerTitle2, rContainerTitle2;
    JTextField searchTxt;
    JButton pMarkAttendance, pDeactivate, pActivate, pRevert, rMarkAttendance, rDeactivate, rActivate, rRevert;
    Font btnFont;
    Color btnColor, btntextColor;

    //initializing Finance Management
    JPanel financeManagementPanel, pFinanceContainer, rFinanceContainer;
    JLabel financeManagementLabel, financeSearch, amtLabel, payAmountLabel, calculateLabel, upgradePlanTitle, selectAPlan, planPriceLabel, box1, box2, box3, box4, box5, box6, box7, box8;
    JTextField financeSearchField, enterAmtField, planPriceField;
    JComboBox financePlan;
    JButton payDueAmountBtn, calculateDiscountBtn, upgradePlanBtn;
    
    //intitializing Display
    JPanel displayPanel;
    JPanel displayContainer1, displayContainer2, displayContainer3;
    JLabel b1,b2,b3, displaySearch;
    JTextField displaySearchTxt;
    JButton dSearchBtn;
    JLabel c1Title, c2Title, c3Title;
    JLabel dName, dId,dLocation, dGender, dDob, dPhone, dEmail;
    JLabel dMembershipDate, dAttendance, dLoyaltyPoints, dActiveStatus, dPersonalTrainer;
    JLabel dPaidAmount, dRemainingAmount, dDiscount;
    
    //no member display
    JPanel noMember;
    JLabel noMemberLabel1, noMemberLabel2;

    // For file related
    File file;
    FileReader fileReader;
    FileWriter fileWriter;
    GymGui() {
        frame = new JFrame("Blackthrone GYM - Registration Form");
        fileFrame = new JFrame("Members Detail");
        
        //adding logo
        dashIcon = new ImageIcon("logo in black.png");
        logo = new JLabel(dashIcon);
        logo.setBounds(320, 1, 90, 90);
        
        //creating FONT
        dashboardTitle = new Font("Inter", Font.PLAIN, 25);
        subTitle = new Font("Inter", Font.PLAIN, 16);
        subLabel = new Font("Inter", Font.PLAIN, 16);
        formTitle = new Font("Inter", Font.BOLD, 28);
        formSubTitle = new Font("Inter",Font.BOLD, 26);
        formLabelFont = new Font("Inter", Font.PLAIN, 18);
        //creating Cursor
        pointerCursor = new Cursor(Cursor.HAND_CURSOR);

        //setting Icon of the frame
        icon = new ImageIcon("logo in white.png");

        //Dashbord Panel
        dashboardPanel = new JPanel();
        dashboardPanel.setLayout(null);
        dashboardPanel.setBounds(0, 0, 320, 710);
        dashboardPanel.setBackground(Color.decode("#444444"));
        
        //creating elemet of Dashboard Panel
        dashboardLabel = new JLabel("Dashboard");
        
        line = new JPanel();
        addMemberLabel = new JLabel("Add Members");
        premiumMember = new JLabel("Premium Members");
        regularMember = new JLabel("Regular Members");
        line2 = new JPanel();
        MemberControLabel = new JLabel("Member Control");
        activateMembership = new JLabel("Activate Memebership");
        deActivateMembership = new JLabel("Deactivate Memebership");
        revertMember = new JLabel("Revert Member");
        markAttendance = new JLabel("Mark Attendance");
        line3 = new JPanel();
        financeManagent = new JLabel("Finance Management");
        payDueAmount = new JLabel("Pay Due Amount");
        calculateDiscount = new JLabel("Calculate Discount");
        upgradePlan = new JLabel("Upgrade Plan");
        line4 = new JPanel();
        read = new JLabel("Read");
        display = new JLabel("Display");
        readFromFile = new JLabel("Read from File");
        saveTofile = new JLabel("Save to File");
        
        //adding attribriute to Dashboard panel element
        dashboardLabel.setForeground(Color.decode("#FFBB33"));
        dashboardLabel.setFont(dashboardTitle);
        line.setBackground(Color.decode("#B7B5B5"));
        addMemberLabel.setForeground(Color.decode("#B7B5B5"));
        addMemberLabel.setFont(subTitle);
        regularMember.setFont(subLabel);
        premiumMember.setFont(subLabel);
        premiumMember.setForeground(Color.white);
        regularMember.setForeground(Color.white);
        line2.setBackground(Color.decode("#B7B5B5"));
        MemberControLabel.setForeground(Color.decode("#B7B5B5"));
        MemberControLabel.setFont(subTitle);
        activateMembership.setFont(subLabel);
        deActivateMembership.setFont(subLabel);
        revertMember.setFont(subLabel);
        markAttendance.setFont(subLabel);
        activateMembership.setForeground(Color.white);
        deActivateMembership.setForeground(Color.white);
        revertMember.setForeground(Color.white);
        markAttendance.setForeground(Color.white);
        financeManagent.setForeground(Color.decode("#B7B5B5"));
        financeManagent.setFont(subTitle);
        line3.setBackground(Color.decode("#B7B5B5"));
        payDueAmount.setFont(subLabel);
        calculateDiscount.setFont(subLabel);
        upgradePlan.setFont(subLabel);
        payDueAmount.setForeground(Color.white);
        calculateDiscount.setForeground(Color.white);
        upgradePlan.setForeground(Color.white);
        line4.setBackground(Color.decode("#B7B5B5"));
        read.setForeground(Color.decode("#B7B5B5"));
        display.setForeground(Color.WHITE);
        read.setFont(subTitle);
        display.setFont(subLabel);
        readFromFile.setFont(subLabel);
        readFromFile.setForeground(Color.WHITE);
        saveTofile.setFont(subLabel);
        saveTofile.setForeground(Color.WHITE);

        //setBound element of Dashboard panel
        dashboardLabel.setBounds(25, 30, 120, 30);
        line.setBounds(14, 78, 290, 1);
        addMemberLabel.setBounds(15, 83, 100, 30);
        premiumMember.setBounds(50, 120, 150, 30);
        regularMember.setBounds(50, 150, 150, 30);
        line2.setBounds(14, 190, 290, 1);
        MemberControLabel.setBounds(15, 196, 150, 30);
        activateMembership.setBounds(50, 231, 160, 30);
        deActivateMembership.setBounds(50, 266, 180, 30);
        revertMember.setBounds(50, 301, 130, 30);
        markAttendance.setBounds(50, 336, 130, 30);
        line3.setBounds(14, 371, 290, 1);
        financeManagent.setBounds(15, 377, 150, 30);
        payDueAmount.setBounds(50, 412, 140, 30);
        calculateDiscount.setBounds(50, 447, 140, 30);
        upgradePlan.setBounds(50, 482, 120, 30);
        line4.setBounds(14, 521, 290, 1);
        read.setBounds(15, 530, 150, 30);
        display.setBounds(50, 565, 70, 30);
        readFromFile.setBounds(50, 600, 130, 30);
        saveTofile.setBounds(50, 635, 130, 30);

        //adding elenent to Dashboard panel
        dashboardPanel.add(dashboardLabel);
        dashboardPanel.add(line);
        dashboardPanel.add(addMemberLabel);
        dashboardPanel.add(premiumMember);
        dashboardPanel.add(regularMember);
        dashboardPanel.add(line2);
        dashboardPanel.add(MemberControLabel);
        dashboardPanel.add(activateMembership);
        dashboardPanel.add(deActivateMembership);
        dashboardPanel.add(revertMember);
        dashboardPanel.add(markAttendance);
        dashboardPanel.add(line3);
        dashboardPanel.add(financeManagent);
        dashboardPanel.add(payDueAmount);
        dashboardPanel.add(calculateDiscount);
        dashboardPanel.add(upgradePlan);
        dashboardPanel.add(line4);
        dashboardPanel.add(read);
        dashboardPanel.add(display);
        dashboardPanel.add(readFromFile);
        dashboardPanel.add(saveTofile);

        //Premium member panel
        premiumPanel = new JPanel();
        premiumPanel.setLayout(null);
        premiumPanel.setBounds(320, 0, 888, 680);
        premiumPanel.setBackground(Color.decode("#ffffff"));
        
        //creating Premium member panel element
        formAddLabel = new JLabel("Add Member:");
        premiumAddLabel = new JLabel("Premium Member");
        basicDetail = new JLabel("Basic Details");
        pName = new JLabel("Full Name");
        pNameTxt = new JTextField();
        pId = new JLabel("ID");
        pIdTxt = new JTextField();
        pLocation = new JLabel("Location");
        pLocationTxt = new JTextField();
        pGender = new JLabel("Gender");
        pMale = new JRadioButton("Male");
        pFemale = new JRadioButton("Female");
        pGroup = new ButtonGroup();
        pGroup.add(pMale);
        pGroup.add(pFemale);
        pDOB = new JLabel("Date of Birth");
        DOByear = new JComboBox<>(DOByearArr);
        DOBmonth = new JComboBox<>(DOBmonthArr);
        DOBday = new JComboBox<>(DOBdayArr);
        contact = new JLabel("Contact");
        pPhoneNo = new JLabel("Phone Number");
        pPhoneNoTxt = new JTextField();
        pEmail = new JLabel("Email");
        pEmailTxt = new JTextField();
        membershipDetail = new JLabel("Membership Detail");
        pMembershipStartDate = new JLabel("Membership Start Date");
        membershipyear = new JComboBox<>(membershipyearArr);
        membershipmonth = new JComboBox<>(membershipmonthArr);
        membershipday = new JComboBox<>(membershipdayArr);
        pPersonalTrainer = new JLabel("Personal Trainer");
        pPersonalTrainerTxt = new JTextField();
        pPaidAmount = new JLabel("Paid Amount");
        pPaidAmountTxt = new JTextField();
        pSaveBtn = new JButton("Add");
        pClearBtn = new JButton("Clear");
        
        //adding attributes to Premium member panel element
        formAddLabel.setFont(formTitle);
        premiumAddLabel.setFont(dashboardTitle);
        basicDetail.setFont(formSubTitle);
        pName.setFont(formLabelFont);
        pNameTxt.setFont(formLabelFont);
        pNameTxt.setBackground(Color.decode("#FAF7F7"));
        pNameTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        pId.setFont(formLabelFont);
        pIdTxt.setFont(formLabelFont);
        pIdTxt.setBackground(Color.decode("#FAF7F7"));
        pIdTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        pLocation.setFont(formLabelFont);
        pLocationTxt.setFont(formLabelFont);
        pLocationTxt.setBackground(Color.decode("#FAF7F7"));
        pLocationTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        pGender.setFont(formLabelFont);        
        pMale.setBackground(Color.white);
        pFemale.setBackground(Color.white);
        pMale.setFont(formLabelFont);
        pFemale.setFont(formLabelFont);
        pDOB.setFont(formLabelFont);
        DOByear.setFont(formLabelFont);
        DOBmonth.setFont(formLabelFont);
        DOBday.setFont(formLabelFont);
        DOByear.setBackground(Color.decode("#FAF7F7"));
        DOBmonth.setBackground(Color.decode("#FAF7F7"));
        DOBday.setBackground(Color.decode("#FAF7F7"));
        contact.setFont(formSubTitle);
        pPhoneNo.setFont(formLabelFont);
        pPhoneNoTxt.setFont(formLabelFont);
        pPhoneNoTxt.setBackground(Color.decode("#FAF7F7"));
        pPhoneNoTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        pEmail.setFont(formLabelFont);
        pEmailTxt.setFont(formLabelFont);
        pEmailTxt.setBackground(Color.decode("#FAF7F7"));
        pEmailTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        membershipDetail.setFont(formSubTitle);
        pMembershipStartDate.setFont(formLabelFont);
        membershipyear.setFont(formLabelFont);
        membershipmonth.setFont(formLabelFont);
        membershipday.setFont(formLabelFont);
        membershipyear.setBackground(Color.decode("#FAF7F7"));
        membershipmonth.setBackground(Color.decode("#FAF7F7"));
        membershipday.setBackground(Color.decode("#FAF7F7"));
        pPersonalTrainer.setFont(formLabelFont);
        pPersonalTrainerTxt.setFont(formLabelFont);
        pPersonalTrainerTxt.setBackground(Color.decode("#FAF7F7"));
        pPersonalTrainerTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        pPaidAmount.setFont(formLabelFont);
        pPaidAmountTxt.setFont(formLabelFont);
        pPaidAmountTxt.setBackground(Color.decode("#FAF7F7"));
        pPaidAmountTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        pSaveBtn.setFont(new Font("Inter", Font.BOLD, 14));
        pSaveBtn.setBackground(Color.decode("#444444"));
        pSaveBtn.setForeground(Color.decode("#ffffff"));
        pSaveBtn.setCursor(pointerCursor);
        pClearBtn.setFont(new Font("Inter", Font.BOLD, 14));
        pClearBtn.setBackground(Color.decode("#444444"));
        pClearBtn.setForeground(Color.decode("#ffffff"));
        pClearBtn.setCursor(pointerCursor);
        
        //setBounds for Premium member panel element
        formAddLabel.setBounds(345, 20, 200, 30);
        premiumAddLabel.setBounds(345, 55, 200, 30);
        basicDetail.setBounds(30, 100, 200, 30);
        pName.setBounds(30, 145, 100, 20);
        pNameTxt.setBounds(30, 170, 430, 40);
        pId.setBounds(500, 145, 40, 20);
        pIdTxt.setBounds(500, 170, 330, 40);
        pLocation.setBounds(30, 220, 100, 20);
        pLocationTxt.setBounds(30, 245, 430, 40);
        pGender.setBounds(500, 220, 80, 20);  
        pMale.setBounds(500, 240, 80, 50);
        pFemale.setBounds(580, 240, 100, 50);
        pDOB.setBounds(30, 295, 120, 20);
        DOByear.setBounds(30, 320, 120, 37);
        DOBmonth.setBounds(155, 320, 70, 37);
        DOBday.setBounds(230, 320, 70, 37);
        contact.setBounds(30, 370, 200, 30);
        pPhoneNo.setBounds(30, 405, 150, 20);
        pPhoneNoTxt.setBounds(30, 430, 430, 40);
        pEmail.setBounds(500, 405, 70, 20);
        pEmailTxt.setBounds(500, 430, 330, 40);
        membershipDetail.setBounds(30, 480, 250, 30);
        pMembershipStartDate.setBounds(30, 530, 320, 20);
        membershipyear.setBounds(30, 555, 120, 37);
        membershipmonth.setBounds(155, 555, 70, 37);
        membershipday.setBounds(230, 555, 70, 37);
        pPersonalTrainer.setBounds(340, 530, 320, 20);
        pPersonalTrainerTxt.setBounds(340, 555, 490, 40);
        pSaveBtn.setBounds(650, 30, 80, 40);
        pClearBtn.setBounds(750, 30, 80, 40);

        
        //price and discount element
        pPriceInfo = new JPanel();
        pPriceInfo.setLayout(null);
        pPriceInfo.setBounds(780, 100, 50, 50);
        pPriceInfo.setBackground(Color.decode("#444444"));
        pPriceInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        
        pPriceButton = new JLabel("!");
        pPriceButton.setFont(new Font("Inria Serif", Font.BOLD, 30));
        pPriceButton.setBounds(19, 0, 50, 50);
        pPriceButton.setForeground(Color.white);
        pPriceButton.setCursor(pointerCursor);
        pPriceButton.addMouseListener(this);
        
        pPriceInfo.add(pPriceButton);
        
        pPricePanel = new JPanel();
        pPricePanel.setLayout(null);
        pPricePanel.setBounds(525, 100, 250, 170);
        pPricePanel.setBackground(Color.decode("#e3e3e3"));
        pPricePanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        pPriceDetail = new JLabel("Price Detail");
        pBasicPrice = new JLabel("1) Charge  ->  50,000");
        pStandarrdPrice = new JLabel("2) Discount ->  5,000");
        pPriceLine = new JLabel();

        pPriceDetail.setFont(new Font("Inrai Serif", Font.BOLD, 21));
        pBasicPrice.setFont(new Font("Inrai Serif", Font.PLAIN, 18));
        pStandarrdPrice.setFont(new Font("Inrai Serif", Font.PLAIN, 18));
        pPriceLine.setOpaque(true);
        pPriceLine.setBackground(Color.decode("#444444"));

        pPriceDetail.setBounds(10, 20, 200, 20);
        pBasicPrice.setBounds(20, 65, 200, 20);
        pStandarrdPrice.setBounds(20, 100, 240, 20);
        pPriceLine.setBounds(10, 45, 200, 3);

        pPricePanel.add(pPriceDetail);
        pPricePanel.add(pBasicPrice);
        pPricePanel.add(pStandarrdPrice);
        pPricePanel.add(pPriceLine);

        //adding Premium member element in panel
        premiumPanel.add(formAddLabel);
        premiumPanel.add(premiumAddLabel);
        premiumPanel.add(basicDetail);
        premiumPanel.add(pName);
        premiumPanel.add(pNameTxt);
        premiumPanel.add(pId);
        premiumPanel.add(pIdTxt);
        premiumPanel.add(pLocation);
        premiumPanel.add(pLocationTxt);
        premiumPanel.add(pGender);
        premiumPanel.add(pMale);
        premiumPanel.add(pFemale);
        premiumPanel.add(pDOB);
        premiumPanel.add(DOByear);
        premiumPanel.add(DOBmonth);
        premiumPanel.add(DOBday);
        premiumPanel.add(contact);
        premiumPanel.add(pPhoneNo);
        premiumPanel.add(pPhoneNoTxt);
        premiumPanel.add(pEmail);
        premiumPanel.add(pEmailTxt);
        premiumPanel.add(membershipDetail);
        premiumPanel.add(pMembershipStartDate);
        premiumPanel.add(membershipyear);
        premiumPanel.add(membershipmonth);
        premiumPanel.add(membershipday);
        premiumPanel.add(pPersonalTrainer);
        premiumPanel.add(pPersonalTrainerTxt);
        premiumPanel.add(pSaveBtn);
        premiumPanel.add(pClearBtn);
        premiumPanel.add(pPriceInfo);

        //Regular member panel
        regularPanel = new JPanel();
        regularPanel.setLayout(null);
        regularPanel.setBounds(320, 0, 888, 680);
        regularPanel.setBackground(Color.decode("#ffffff"));
        
        //creating regularMember Panel element
        rformAddLabel = new JLabel("Add Member:");
        regularAddLabel = new JLabel("Regular Member");
        rbasicDetail = new JLabel("Basic Details");
        rName = new JLabel("Full Name");
        rNameTxt = new JTextField();
        rId = new JLabel("ID");
        rIdTxt = new JTextField();
        rLocation = new JLabel("Location");
        rLocationTxt = new JTextField();
        rGender = new JLabel("Gender");
        rMale = new JRadioButton("Male");
        rFemale = new JRadioButton("Female");
        rGroup = new ButtonGroup();
        rGroup.add(rMale);
        rGroup.add(rFemale);
        rDOB = new JLabel("Date of Birth");
        rDOByear = new JComboBox<>(rDOByearArr);
        rDOBmonth = new JComboBox<>(rDOBmonthArr);
        rDOBday = new JComboBox<>(rDOBdayArr);
        rcontact = new JLabel("Contact");
        rPhoneNo = new JLabel("Phone Number");
        rPhoneNoTxt = new JTextField();
        rEmail = new JLabel("Email");
        rEmailTxt = new JTextField();
        rmembershipDetail = new JLabel("Membership Detail");
        rMembershipStartDate = new JLabel("Membership Start Date");
        rmembershipyear = new JComboBox<>(rmembershipyearArr);
        rmembershipmonth = new JComboBox<>(rmembershipmonthArr);
        rmembershipday = new JComboBox<>(rmembershipdayArr);
        rReferalSource = new JLabel("Referral Source");
        rReferalSourceTxt = new JTextField();
        rPlan = new JLabel("Plan");
        rPlanBox = new JComboBox<>(plan);
        rSaveBtn = new JButton("Add");
        rClearBtn = new JButton("Clear");

        //adding Attribute
        rformAddLabel.setFont(formTitle);
        regularAddLabel.setFont(dashboardTitle);
        rbasicDetail.setFont(formSubTitle);
        rName.setFont(formLabelFont);
        rNameTxt.setFont(formLabelFont);
        rNameTxt.setBackground(Color.decode("#FAF7F7"));
        rNameTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        rId.setFont(formLabelFont);
        rIdTxt.setFont(formLabelFont);
        rIdTxt.setBackground(Color.decode("#FAF7F7"));
        rIdTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        rLocation.setFont(formLabelFont);
        rLocationTxt.setFont(formLabelFont);
        rLocationTxt.setBackground(Color.decode("#FAF7F7"));
        rLocationTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        rGender.setFont(formLabelFont);        
        rMale.setBackground(Color.white);
        rFemale.setBackground(Color.white);
        rMale.setFont(formLabelFont);
        rFemale.setFont(formLabelFont);
        rDOB.setFont(formLabelFont);
        rDOByear.setFont(formLabelFont);
        rDOBmonth.setFont(formLabelFont);
        rDOBday.setFont(formLabelFont);
        rcontact.setFont(formSubTitle);
        rDOByear.setBackground(Color.decode("#FAF7F7"));
        rDOBmonth.setBackground(Color.decode("#FAF7F7"));
        rDOBday.setBackground(Color.decode("#FAF7F7"));
        rPhoneNo.setFont(formLabelFont);
        rPhoneNoTxt.setFont(formLabelFont);
        rPhoneNoTxt.setBackground(Color.decode("#FAF7F7"));
        rPhoneNoTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        rEmail.setFont(formLabelFont);
        rEmailTxt.setFont(formLabelFont);
        rEmailTxt.setBackground(Color.decode("#FAF7F7"));
        rEmailTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        rmembershipDetail.setFont(formSubTitle);
        rMembershipStartDate.setFont(formLabelFont);
        rmembershipyear.setFont(formLabelFont);
        rmembershipmonth.setFont(formLabelFont);
        rmembershipday.setFont(formLabelFont);
        rmembershipyear.setBackground(Color.decode("#FAF7F7"));
        rmembershipmonth.setBackground(Color.decode("#FAF7F7"));
        rmembershipday.setBackground(Color.decode("#FAF7F7"));
        rReferalSource.setFont(formLabelFont);
        rReferalSourceTxt.setFont(formLabelFont);
        rReferalSourceTxt.setBackground(Color.decode("#FAF7F7"));
        rReferalSourceTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        rPlan.setFont(formLabelFont);
        rPlan.setFont(formLabelFont);
        rPlanBox.setBackground(Color.decode("#FAF7F7"));
        rPlanBox.setFont(formLabelFont);
        rSaveBtn.setFont(new Font("Inter", Font.BOLD, 14));
        rSaveBtn.setBackground(Color.decode("#444444"));
        rSaveBtn.setForeground(Color.decode("#ffffff"));
        rSaveBtn.setCursor(pointerCursor);
        rClearBtn.setFont(new Font("Inter", Font.BOLD, 14));
        rClearBtn.setBackground(Color.decode("#444444"));
        rClearBtn.setForeground(Color.decode("#ffffff"));
        rClearBtn.setCursor(pointerCursor);

        //setbounds
        rformAddLabel.setBounds(345, 20, 200, 30);
        regularAddLabel.setBounds(345, 55, 200, 30);
        rbasicDetail.setBounds(30, 100, 200, 30);
        rName.setBounds(30, 145, 100, 20);
        rNameTxt.setBounds(30, 170, 430, 40);
        rId.setBounds(500, 145, 40, 20);
        rIdTxt.setBounds(500, 170, 330, 40);
        rLocation.setBounds(30, 220, 100, 20);
        rLocationTxt.setBounds(30, 245, 430, 40);
        rGender.setBounds(500, 220, 80, 20);  
        rMale.setBounds(500, 240, 80, 50);
        rFemale.setBounds(580, 240, 100, 50);
        rDOB.setBounds(30, 295, 120, 20);
        rDOByear.setBounds(30, 320, 120, 37);
        rDOBmonth.setBounds(155, 320, 70, 37);
        rDOBday.setBounds(230, 320, 70, 37);
        rcontact.setBounds(30, 370, 200, 30);
        rPhoneNo.setBounds(30, 405, 150, 20);
        rPhoneNoTxt.setBounds(30, 430, 430, 40);
        rEmail.setBounds(500, 405, 70, 20);
        rEmailTxt.setBounds(500, 430, 330, 40);
        rmembershipDetail.setBounds(30, 480, 250, 30);
        rMembershipStartDate.setBounds(30, 530, 320, 20);
        rmembershipyear.setBounds(30, 555, 120, 37);
        rmembershipmonth.setBounds(155, 555, 70, 37);
        rmembershipday.setBounds(230, 555, 70, 37);
        rReferalSource.setBounds(340, 530, 520, 20);
        rReferalSourceTxt.setBounds(340, 555, 480, 40);
        rPlan.setBounds(700, 530, 130, 20);
        rPlanBox.setBounds(700, 555, 130, 40);
        rSaveBtn.setBounds(650, 30, 80, 40);
        rClearBtn.setBounds(750, 30, 80, 40);

        //price and discount element
        rPriceInfo = new JPanel();
        rPriceInfo.setLayout(null);
        rPriceInfo.setBounds(780, 100, 50, 50);
        rPriceInfo.setBackground(Color.decode("#444444"));
        rPriceInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        
        rPriceButton = new JLabel("!");
        rPriceButton.setFont(new Font("Inria Serif", Font.BOLD, 30));
        rPriceButton.setBounds(19, 0, 50, 50);
        rPriceButton.setForeground(Color.white);
        rPriceButton.setCursor(pointerCursor);
        rPriceButton.addMouseListener(this);
        
        rPriceInfo.add(rPriceButton);
        
        rPricePanel = new JPanel();
        rPricePanel.setLayout(null);
        rPricePanel.setBounds(525, 100, 250, 170);
        rPricePanel.setBackground(Color.decode("#e3e3e3"));
        rPricePanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        rPriceDetail = new JLabel("Price Detail");
        rBasicPrice = new JLabel("1) Basic Price  -> 6,500");
        rStandarrdPrice = new JLabel("2) Standard Price -> 12,500");
        rDeluxePrice = new JLabel("3) Deluxe Price  -> 18,500");
        rPriceLine = new JLabel();

        rPriceDetail.setFont(new Font("Inrai Serif", Font.BOLD, 21));
        rBasicPrice.setFont(new Font("Inrai Serif", Font.PLAIN, 18));
        rStandarrdPrice.setFont(new Font("Inrai Serif", Font.PLAIN, 18));
        rDeluxePrice.setFont(new Font("Inrai Serif", Font.PLAIN, 18));
        rPriceLine.setOpaque(true);
        rPriceLine.setBackground(Color.decode("#444444"));

        rPriceDetail.setBounds(10, 20, 200, 20);
        rBasicPrice.setBounds(20, 65, 200, 20);
        rStandarrdPrice.setBounds(20, 100, 240, 20);
        rDeluxePrice.setBounds(20, 135, 240, 20);
        rPriceLine.setBounds(10, 45, 200, 3);

        rPricePanel.add(rPriceDetail);
        rPricePanel.add(rBasicPrice);
        rPricePanel.add(rStandarrdPrice);
        rPricePanel.add(rDeluxePrice);
        rPricePanel.add(rPriceLine);

        //adding element to regular member panel
        regularPanel.add(rformAddLabel);
        regularPanel.add(regularAddLabel);
        regularPanel.add(rbasicDetail);
        regularPanel.add(rName);
        regularPanel.add(rNameTxt);
        regularPanel.add(rId);
        regularPanel.add(rIdTxt);
        regularPanel.add(rLocation);
        regularPanel.add(rLocationTxt);
        regularPanel.add(rGender);
        regularPanel.add(rMale);
        regularPanel.add(rFemale);
        regularPanel.add(rDOB);
        regularPanel.add(rDOByear);
        regularPanel.add(rDOBmonth);
        regularPanel.add(rDOBday);
        regularPanel.add(rcontact);
        regularPanel.add(rPhoneNo);
        regularPanel.add(rPhoneNoTxt);
        regularPanel.add(rEmail);
        regularPanel.add(rEmailTxt);
        regularPanel.add(rmembershipDetail);
        regularPanel.add(rMembershipStartDate);
        regularPanel.add(rmembershipyear);
        regularPanel.add(rmembershipmonth);
        regularPanel.add(rmembershipday);
        regularPanel.add(rReferalSource);
        regularPanel.add(rReferalSourceTxt);
        //regularPanel.add(rPlan);
        //regularPanel.add(rPlanBox);
        regularPanel.add(rSaveBtn);
        regularPanel.add(rClearBtn);
        regularPanel.add(rPriceInfo);

        //creating member Control Panel
        memberControlPanel = new JPanel();
        memberControlPanel.setLayout(null);
        memberControlPanel.setBackground(Color.white);
        memberControlPanel.setBounds(320, 0, 888, 680);
        
        //creating element of member Control Panel
        memberControlLabel = new JLabel("Member Control");
        searchLabel = new JLabel("Enter member ID");
        searchTxt = new JTextField();
        pMemberContainer = new JPanel();
        rMemberContainer = new JPanel();
        pContainerTitle = new JLabel("What would you like");
        rContainerTitle = new JLabel("What would you like");
        pContainerTitle2 = new JLabel("to do");
        rContainerTitle2 = new JLabel("to do");
        pMarkAttendance = new JButton("Mark Attendance");
        btnFont = new Font("Monospaced", Font.BOLD, 18);
        btnColor = Color.decode("#444444");
        btntextColor = Color.decode("#ffffff");
        pMarkAttendance = new JButton("Mark Attendance");
        pDeactivate = new JButton("Deactivate Membership");
        pActivate = new JButton("Activate Membership");
        pRevert = new JButton("Revert Member");
        rMarkAttendance = new JButton("Mark Attendance");
        rDeactivate = new JButton("Deactivate Membership");
        rActivate = new JButton("Activate Membership");
        rRevert = new JButton("Revert Member");

        //adding attributes to member control element
        memberControlLabel.setFont(new Font("Inter", Font.BOLD, 30));
        searchLabel.setFont(formLabelFont);
        searchTxt.setFont(formLabelFont);
        searchTxt.setBackground(Color.decode("#faf7f7"));
        searchTxt.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        pMemberContainer.setLayout(null);
        rMemberContainer.setLayout(null);
        pContainerTitle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        rContainerTitle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        pContainerTitle2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        rContainerTitle2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        pMarkAttendance.setFont(btnFont);
        pDeactivate.setFont(btnFont);
        pActivate.setFont(btnFont);
        pRevert.setFont(btnFont);
        rMarkAttendance.setFont(btnFont);
        rDeactivate.setFont(btnFont);
        rActivate.setFont(btnFont);
        rRevert.setFont(btnFont);
        pMarkAttendance.setBackground(btnColor);
        pActivate.setBackground(btnColor);
        pDeactivate.setBackground(btnColor);
        pRevert.setBackground(btnColor);
        rMarkAttendance.setBackground(btnColor);
        rActivate.setBackground(btnColor);
        rDeactivate.setBackground(btnColor);
        rRevert.setBackground(btnColor);
        pMarkAttendance.setForeground(btntextColor);
        pDeactivate.setForeground(btntextColor);
        pActivate.setForeground(btntextColor);
        pRevert.setForeground(btntextColor);
        rMarkAttendance.setForeground(btntextColor);
        rDeactivate.setForeground(btntextColor);
        rActivate.setForeground(btntextColor);
        rRevert.setForeground(btntextColor);

        //creating title border and setting font size
        TitledBorder pTitleBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3), "Premium Member");
        TitledBorder rTitleBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 3), "Regular Member");
        pTitleBorder.setTitleFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
        rTitleBorder.setTitleFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
        pMemberContainer.setBorder(pTitleBorder);
        rMemberContainer.setBorder(rTitleBorder);
        pMemberContainer.setBackground(Color.white);
        rMemberContainer.setBackground(Color.white);
        

        //setBounds
        memberControlLabel.setBounds(345, 20, 250, 30);
        searchLabel.setBounds(80, 70, 200, 30);
        searchTxt.setBounds(80, 100, 400, 30);
        pMemberContainer.setBounds(40, 150, 390, 450);
        rMemberContainer.setBounds(460, 150, 390, 450);
        pContainerTitle.setBounds(25, 40, 370, 30);
        rContainerTitle.setBounds(25, 40, 370, 30);
        pContainerTitle2.setBounds(25, 80, 370, 30);
        rContainerTitle2.setBounds(25, 80, 370, 30);
        pMarkAttendance.setBounds(70, 150, 280, 40);
        pActivate.setBounds(70, 210, 280, 40);
        pDeactivate.setBounds(70, 270, 280, 40);
        pRevert.setBounds(70, 330, 280, 40);
        rMarkAttendance.setBounds(70, 150, 280, 40);
        rActivate.setBounds(70, 210, 280, 40);
        rDeactivate.setBounds(70, 270, 280, 40);
        rRevert.setBounds(70, 330, 280, 40);

       
        pMemberContainer.add(pContainerTitle);
        pMemberContainer.add(pContainerTitle2);
        pMemberContainer.add(pMarkAttendance);
        pMemberContainer.add(pDeactivate);
        pMemberContainer.add(pActivate);
        pMemberContainer.add(pRevert);

        rMemberContainer.add(rContainerTitle2);
        rMemberContainer.add(rContainerTitle);
        rMemberContainer.add(rMarkAttendance);
        rMemberContainer.add(rDeactivate);
        rMemberContainer.add(rActivate);
        rMemberContainer.add(rRevert);

        //adding to member Control panel element
        memberControlPanel.add(memberControlLabel);
        memberControlPanel.add(searchLabel);
        memberControlPanel.add(searchTxt);
        memberControlPanel.add(pMemberContainer);
        memberControlPanel.add(rMemberContainer);

        //creating financeManagementPanel
        financeManagementPanel = new JPanel();
        financeManagementPanel.setLayout(null);
        financeManagementPanel.setBackground(Color.white);
        financeManagementPanel.setBounds(320, 0, 888, 680);

        //creating financeManagementPanel elements
        financeManagementLabel = new JLabel("Finance Management");
        financeSearch = new JLabel("Enter member ID");
        financeSearchField = new JTextField();
        enterAmtField = new JTextField();
        amtLabel = new JLabel("Enter Amount");
        upgradePlanTitle = new JLabel("Upgrade Plan:");
        selectAPlan = new JLabel("Select Plan");
        planPriceLabel = new JLabel("Price: ");
        planPriceField = new JTextField(" 6500");
        box1 = new JLabel("");
        box2 = new JLabel("");
        box3 = new JLabel("");
        box4 = new JLabel("");
        box5 = new JLabel("");
        box6 = new JLabel("");
        box7 = new JLabel("");
        box8 = new JLabel("");
        pFinanceContainer = new JPanel();
        rFinanceContainer = new JPanel();
        financePlan = new JComboBox<>(plan);
        payAmountLabel = new JLabel("Pay Amount:");
        payDueAmountBtn = new JButton("Pay Due Amount");
        calculateLabel = new JLabel("Discount:");
        calculateDiscountBtn = new JButton("Calculate Discount");
        upgradePlanBtn = new JButton("Upgrade Plan");
        
        //adding Attributes
        financeManagementLabel.setFont(new Font("Arial", Font.BOLD, 30));
        financeSearch.setFont(formLabelFont);
        financeSearchField.setBackground(Color.decode("#faf7f7"));
        financeSearchField.setFont(formLabelFont);
        financeSearchField.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        pFinanceContainer.setLayout(null);
        rFinanceContainer.setLayout(null);
        pFinanceContainer.setBackground(Color.white);
        rFinanceContainer.setBackground(Color.white);

        //creating title border and setting font size
        pFinanceContainer.setBorder(pTitleBorder);
        rFinanceContainer.setBorder(rTitleBorder);

        amtLabel.setFont(formLabelFont);
        enterAmtField.setFont(formLabelFont);
        enterAmtField.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        enterAmtField.setBackground(Color.decode("#faf7f7"));
        payAmountLabel.setFont(formLabelFont);
        payDueAmountBtn.setBackground(btnColor);
        payDueAmountBtn.setForeground(btntextColor);
        calculateLabel.setFont(formLabelFont);
        calculateDiscountBtn.setBackground(btnColor);
        calculateDiscountBtn.setForeground(btntextColor);

        selectAPlan.setFont(formLabelFont);
        financePlan.setFont(formLabelFont);
        financePlan.setBackground(Color.decode("#faf7f7"));
        upgradePlanTitle.setFont(formLabelFont);
        planPriceLabel.setFont(formLabelFont);
        planPriceField.setFont(formLabelFont);
        planPriceField.setBackground(Color.decode("#faf7f7"));
        planPriceField.setEditable(false);
        upgradePlanBtn.setForeground(btntextColor);
        upgradePlanBtn.setBackground(btnColor);
        
        box1.setBackground(btnColor);
        box2.setBackground(btnColor);
        box3.setBackground(btnColor);
        box4.setBackground(btnColor);
        box5.setBackground(btnColor);
        box6.setBackground(btnColor);
        box7.setBackground(btnColor);
        box8.setBackground(btnColor);

        box1.setOpaque(true);
        box2.setOpaque(true);
        box3.setOpaque(true);
        box4.setOpaque(true);
        box5.setOpaque(true);
        box6.setOpaque(true);
        box7.setOpaque(true);
        box8.setOpaque(true);

        //setBounds
        financeManagementLabel.setBounds(280, 20, 320, 35);
        financeSearch.setBounds(80, 70, 200, 30);
        financeSearchField.setBounds(80, 100, 400, 30);
        pFinanceContainer.setBounds(40, 150, 390, 270);
        rFinanceContainer.setBounds(460, 260, 390, 270);
        amtLabel.setBounds(30, 30, 120, 30);
        enterAmtField.setBounds(30, 60, 320, 30);
        payDueAmountBtn.setBounds(190, 120, 150, 40);
        calculateDiscountBtn.setBounds(190, 180, 150, 40);
        payAmountLabel.setBounds(40, 120, 150, 40);
        calculateLabel.setBounds(40, 180, 150, 40);
        selectAPlan.setBounds(30, 30, 120, 30);
        financePlan.setBounds(30, 70, 320, 30);
        planPriceLabel.setBounds(40, 120, 120, 30);
        planPriceField.setBounds(100, 120, 250, 30);
        upgradePlanTitle.setBounds(40, 170, 150, 40);
        upgradePlanBtn.setBounds(190, 170, 150, 40);

        //random box design
        box1.setBounds(300, 440, 130, 87);
        box2.setBounds(190, 440, 100, 57);
        box3.setBounds(110, 440, 70, 37);
        box4.setBounds(60, 440, 40, 20);

        box5.setBounds(460, 160, 130, 87);
        box6.setBounds(600, 190, 100, 57);
        box7.setBounds(710, 210, 70, 37);
        box8.setBounds(790, 227, 40, 20);

        //adding to finance management panel element
        financeManagementPanel.add(financeManagementLabel);
        financeManagementPanel.add(financeSearch);
        financeManagementPanel.add(financeSearchField);
        financeManagementPanel.add(pFinanceContainer);
        financeManagementPanel.add(rFinanceContainer);
        financeManagementPanel.add(box1);
        financeManagementPanel.add(box2);
        financeManagementPanel.add(box3);
        financeManagementPanel.add(box4);
        financeManagementPanel.add(box5);
        financeManagementPanel.add(box6);
        financeManagementPanel.add(box7);
        financeManagementPanel.add(box8);

        pFinanceContainer.add(amtLabel);
        pFinanceContainer.add(enterAmtField);
        pFinanceContainer.add(payAmountLabel);
        pFinanceContainer.add(payDueAmountBtn);
        pFinanceContainer.add(calculateLabel);
        pFinanceContainer.add(calculateDiscountBtn);

        rFinanceContainer.add(selectAPlan);
        rFinanceContainer.add(financePlan);
        rFinanceContainer.add(upgradePlanTitle);
        rFinanceContainer.add(upgradePlanBtn);
        rFinanceContainer.add(planPriceLabel);
        rFinanceContainer.add(planPriceField);
    
        //for display panel
        displayPanel = new JPanel();
        displayPanel.setBounds(320, 0, 888, 680);
        displayPanel.setLayout(null);
        displayPanel.setBackground(Color.white);
        
        //creating display panel element
        displaySearch = new JLabel("Enter Member ID");
        displaySearchTxt = new JTextField();
        dSearchBtn = new JButton("Search");
        displayContainer1 = new JPanel();
        displayContainer2 = new JPanel();
        displayContainer3 = new JPanel();
        b1 = new JLabel("");
        b2 = new JLabel("");
        b3 = new JLabel("");
        c1Title = new JLabel("Basic Details");
        c2Title = new JLabel("Membership Detail");
        c3Title = new JLabel("Account");
        dName = new JLabel("Name:");
        dId = new JLabel("ID:");
        dLocation = new JLabel("Location:");
        dGender = new JLabel("Gender:");
        dDob = new JLabel("Date of Birth:");
        dPhone = new JLabel("Phone number:");
        dEmail = new JLabel("Email:");
        dMembershipDate = new JLabel("Membership Start Date:");
        dAttendance = new JLabel("Attendance:");
        dLoyaltyPoints = new JLabel("Loyalty Points:");
        dActiveStatus = new JLabel("Active Status:");
        dPersonalTrainer = new JLabel("Personal Trainer:");
        dPaidAmount = new JLabel("Paid Amount:");
        dRemainingAmount = new JLabel("Remaning amount:");
        dDiscount = new JLabel("Discount:");
        
        //adding attributes
        displaySearch.setFont(formLabelFont);
        displaySearchTxt.setBackground(Color.decode("#faf7f7"));
        displaySearchTxt.setFont(formLabelFont);
        displaySearchTxt.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        dSearchBtn.setForeground(Color.white);
        dSearchBtn.setBackground(Color.decode("#444444"));
        dSearchBtn.setFont(formLabelFont);
        displayContainer1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        displayContainer1.setBackground(Color.white);
        displayContainer2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        displayContainer2.setBackground(Color.white);
        displayContainer3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        displayContainer3.setBackground(Color.white);
        b1.setBackground(Color.decode("#444444"));
        b2.setBackground(Color.decode("#444444"));
        b3.setBackground(Color.decode("#444444"));
        b1.setOpaque(true);
        b2.setOpaque(true);
        b3.setOpaque(true);
        c1Title.setFont(new Font("Arial", Font.PLAIN, 27)); 
        c2Title.setFont(new Font("Arial", Font.PLAIN, 27));  
        c3Title.setFont(new Font("Arial", Font.PLAIN, 27));  
        c1Title.setForeground(Color.decode("#FFBB33"));
        c2Title.setForeground(Color.decode("#FFBB33"));
        c3Title.setForeground(Color.decode("#FFBB33"));
        displayFont = new Font("Arial", Font.PLAIN, 21);
        dName.setFont(displayFont);
        dId.setFont(displayFont);
        dLocation.setFont(displayFont);
        dGender.setFont(displayFont);
        dDob.setFont(displayFont);
        dPhone.setFont(displayFont);
        dEmail.setFont(displayFont);
        dMembershipDate.setFont(displayFont);
        dAttendance.setFont(displayFont);
        dLoyaltyPoints.setFont(displayFont);
        dActiveStatus.setFont(displayFont);
        dPersonalTrainer.setFont(displayFont);
        dPaidAmount.setFont(displayFont);
        dRemainingAmount.setFont(displayFont);
        dDiscount.setFont(displayFont);
        
        //setBounds
        displaySearch.setBounds(220, 30, 200, 25);
        displaySearchTxt.setBounds(220, 60, 360, 30);
        dSearchBtn.setBounds(590, 58, 100, 33);
        displayContainer1.setBounds(60, 110, 370, 470);
        displayContainer2.setBounds(440, 110, 400, 260);
        displayContainer3.setBounds(440, 380, 400, 195);
        b1.setBounds(0, 0, 370, 43);
        b2.setBounds(0, 0, 400, 43);
        b3.setBounds(0, 0, 400, 43);
        c1Title.setBounds(100, 116, 200, 30);
        c2Title.setBounds(480, 116, 300, 30);
        c3Title.setBounds(480, 386, 200, 30);
        dName.setBounds(40, 80, 300, 30);
        dId.setBounds(40, 120, 300, 30);
        dLocation.setBounds(40, 160, 300, 30);
        dGender.setBounds(40, 200, 300, 30);
        dDob.setBounds(40, 240, 300, 30);
        dPhone.setBounds(40, 280, 300, 30);
        dEmail.setBounds(40, 320, 300, 30);
        dMembershipDate.setBounds(40, 60, 350, 30);
        dAttendance.setBounds(40, 100, 300, 30);
        dLoyaltyPoints.setBounds(40, 140, 300, 30);
        dActiveStatus.setBounds(40, 180, 300, 30);
        dPersonalTrainer.setBounds(40, 220, 300, 30);
        dPaidAmount.setBounds(40, 60, 300, 30);
        dRemainingAmount.setBounds(40, 100, 300, 30);
        dDiscount.setBounds(40, 140, 300, 30);
        
        displayContainer1.add(b1);
        displayContainer1.add(dName);
        displayContainer1.add(dId);
        displayContainer1.add(dLocation);
        displayContainer1.add(dGender);
        displayContainer1.add(dDob);
        displayContainer1.add(dPhone);
        displayContainer1.add(dEmail);
        
        displayContainer2.add(b2);
        displayContainer2.add(dMembershipDate);
        displayContainer2.add(dAttendance);
        displayContainer2.add(dLoyaltyPoints);
        displayContainer2.add(dActiveStatus);
        displayContainer2.add(dPersonalTrainer);
        
        displayContainer3.add(b3);
        displayContainer3.add(dPaidAmount);
        displayContainer3.add(dRemainingAmount);
        displayContainer3.add(dDiscount);
        
        displayContainer1.setLayout(null);
        displayContainer2.setLayout(null);
        displayContainer3.setLayout(null);
        
        //adding element to Display panel
        displayPanel.add(displaySearch);
        displayPanel.add(displaySearchTxt);
        displayPanel.add(dSearchBtn);
        displayPanel.add(displayContainer1);
        displayPanel.add(displayContainer2);
        displayPanel.add(displayContainer3);
        displayPanel.add(c1Title);
        displayPanel.add(c2Title);
        displayPanel.add(c3Title);
        
        //no member display panel
        noMember =  new JPanel();
        noMember.setLayout(null);
        noMember.setBackground(Color.white);
        noMember.setBounds(320, 0, 888, 680);
        noMemberLabel1 = new JLabel("Looks like we don't");
        noMemberLabel2 = new JLabel("have any Members");
        noMemberLabel1.setForeground(Color.decode("#4e4e4e"));
        noMemberLabel2.setForeground(Color.decode("#4e4e4e"));
        noMemberLabel1.setFont(new Font("Arial", Font.BOLD, 53));
        noMemberLabel2.setFont(new Font("Arial", Font.BOLD, 53));
        noMemberLabel1.setBounds(200, 190, 600, 80);
        noMemberLabel2.setBounds(200, 320, 600, 80);
        noMember.add(noMemberLabel1);
        noMember.add(noMemberLabel2);

        displayPanel.setComponentZOrder(c1Title, 0);
        displayPanel.setComponentZOrder(c2Title, 0);
        displayPanel.setComponentZOrder(c3Title, 0);
        //adding event listener
        premiumMember.addMouseListener(this);
        regularMember.addMouseListener(this);
        activateMembership.addMouseListener(this);
        deActivateMembership.addMouseListener(this);
        revertMember.addMouseListener(this);
        markAttendance.addMouseListener(this);
        payDueAmount.addMouseListener(this);
        calculateDiscount.addMouseListener(this);
        upgradePlan.addMouseListener(this);
        display.addMouseListener(this);
        readFromFile.addMouseListener(this);
        saveTofile.addMouseListener(this);

        //event Listener in clear and save Btn
        pSaveBtn.addActionListener(this);
        pClearBtn.addActionListener(this);
        rSaveBtn.addActionListener(this);
        rClearBtn.addActionListener(this);

        //event listener added to btn in member control panel
        pMarkAttendance.addActionListener(this);
        pActivate.addActionListener(this);
        pDeactivate.addActionListener(this);
        pRevert.addActionListener(this);
        rMarkAttendance.addActionListener(this);
        rActivate.addActionListener(this);
        rDeactivate.addActionListener(this);
        rRevert.addActionListener(this);
        
        //event listener add to btn of finance panel
        payDueAmountBtn.addActionListener(this);
        calculateDiscountBtn.addActionListener(this);
        upgradePlanBtn.addActionListener(this);
        financePlan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) financePlan.getSelectedItem();
                if (selectedItem == "Basic".trim()) {
                    planPriceField.setText(" 6500");
                }
                else if (selectedItem == "Standard".trim()) {
                    planPriceField.setText(" 12500");
                }
                else {
                    planPriceField.setText(" 18500");
                }
            }
        });
        //eventListener to searchBtn on display
        dSearchBtn.addActionListener(this);
        
        //adding element to Frame
        frame.setIconImage(icon.getImage());
        frame.add(logo);
        frame.add(dashboardPanel);
        frame.add(premiumPanel);

        //setting frame size
        frame.setSize(1208, 710);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //created a textArea to store data from file
        fileLabel = new JTextArea("Test Text");
        fileLabel.setBounds(10,10, 2000, 400);
        fileLabel.setEditable(false);  
        fileLabel.setFont(new Font("Consolas",Font.PLAIN, 16));
        //fileLabel.setLineWrap(false);
        fileLabel.setFocusable(false);            
        fileLabel.setOpaque(false);  
        
        //created a scrollpane that has a textarea
        JScrollPane scrollPane = new JScrollPane(fileLabel);
        scrollPane.setBounds(0, 0, 1208, 710);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.getHorizontalScrollBar().setOpaque(false);
        
        //adding scrollpane to fileFrame
        fileFrame.add(scrollPane);
        
        //fileFrame size adjstment
        fileFrame.setSize(1208, 710);
        fileFrame.getContentPane().setBackground(Color.decode("#ffffff"));
        fileFrame.setLayout(null);
        fileFrame.setResizable(false);
        fileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fileFrame.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //code for panel switch
        JLabel lbl = (JLabel) e.getSource();
        switch (lbl.getText()) {
            case "Premium Members":
                frame.getContentPane().removeAll(); // Remove all panels
                frame.add(dashboardPanel);
                frame.add(logo);
                frame.add(premiumPanel);
                break;
            case "Regular Members":
                frame.getContentPane().removeAll();
                frame.add(dashboardPanel);
                frame.add(logo);
                frame.add(regularPanel);
                break;
            case "Activate Memebership":
            case "Deactivate Memebership":
            case "Revert Member":
            case "Mark Attendance":
                frame.getContentPane().removeAll();
                frame.add(dashboardPanel);
                frame.add(logo);
                frame.add(memberControlPanel);
                break;
            case "Upgrade Plan":
            case "Calculate Discount":
            case "Pay Due Amount":
                frame.getContentPane().removeAll();
                frame.add(dashboardPanel);
                frame.add(logo);
                frame.add(financeManagementPanel);
                break;
            case "Display":
                frame.getContentPane().removeAll();
                frame.add(dashboardPanel);
                frame.add(logo);
                if (memberList.isEmpty()) {
                    //System.out.print("member list is empty");
                    frame.add(noMember);
                }
                else {
                    frame.remove(noMember);
                    frame.add(displayPanel);
                }
                
                break;
            case "Read from File":
                try {
                    fileReader = new FileReader("MemberDetails.txt");
                    int startChar = fileReader.read();
                    if (startChar == -1) {
                        JOptionPane.showMessageDialog(frame, "No Data Available", "Data not Available", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        fileFrame.setVisible(true);
                        String sentence = "";
                        int letter;
                        while ((letter = fileReader.read()) != -1) {
                            sentence += (char) letter;
                        }
                        fileLabel.setText(sentence);
                        fileReader.close();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "File not found or cannot be read.", "Data not Available", JOptionPane.ERROR_MESSAGE);
                }
                break;

            
            case "Save to File":
                // System.out.println("Saving to file...");
                int response = JOptionPane.showConfirmDialog(null,"Save all the Data in the file?",   "Save To file", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {
                //creating a new file
                try {
                    file = new File("MemberDetails.txt");
                    file.createNewFile();
                    fileWriter = new FileWriter("MemberDetails.txt");
                    if (memberList.isEmpty()) {
                       JOptionPane.showMessageDialog(frame, "No member Data Available", "Data not Available", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        fileWriter.write("Premium Member:\n");
                        int it = 1;
                        while(it < 260){
                            fileWriter.write("=");
                            it++;
                        }
                        fileWriter.write("\n");
                        fileWriter.write(String.format("%-5s %-17s %-15s %-10s %-15s %-15s %-25s %-25s %-15s %-15s %-15s %-20s %-15s %-20s %-20s\n",
                            "ID", "Name", "Location", "Gender", "DOB", "Phone", "Email", "Membership Start Date", "Attendance", "Loyalty Points", "Active Status", "Personal Trainer", "Paid Amount", "Discount", "Remaining Amount"));
                        it = 1;
                        while(it < 260){
                            fileWriter.write("=");
                            it++;
                        }
                        fileWriter.write("\n");
                        for (GymMember member : memberList) {
                            if (member instanceof PremiumMember) {
                                PremiumMember pm = (PremiumMember) member;
                                fileWriter.write(String.format("%-5s %-17s %-15s %-10s %-15s %-15s %-25s %-25s %-15s %-15s %-15s %-20s %-15s %-20s %-20s\n",
                                    pm.getId(), pm.getName(), pm.getLocation(), pm.getGender(), pm.getDOB(),
                                    pm.getPhone(), pm.getEmail(), pm.getMembershipStartDate(), pm.getAttendance(), pm.getLoyaltyPoints(), pm.isActiveStatus(), pm.getPersonalTrainer(),
                                    (pm.getPaidAmount()-pm.getDiscountAmount()), pm.getDiscountAmount(),(50000.00 - pm.getPaidAmount())));
                                
                            }
                        }
                        it = 1;
                        while(it < 260){
                            fileWriter.write("-");
                            it++;
                        }
                        fileWriter.write("\n\nRegular Member:\n");
                        it = 1;
                        while(it < 260){
                            fileWriter.write("=");
                            it++;
                        }
                        fileWriter.write("\n");
                        fileWriter.write(String.format("%-5s %-17s %-15s %-10s %-15s %-15s %-25s %-25s %-15s %-15s %-15s %-20s %-15s %-20s %-20s\n",
                        "ID", "Name", "Location", "Gender", "DOB", "Phone", "Email", "Membership Start Date", "Attendance", "Loyalty Points", "Active Status", "Plan", "Price", "Referral Source", "Removal Reason"));
                        it = 1;
                        while(it < 260){
                            fileWriter.write("=");
                            it++;
                        }
                        fileWriter.write("\n");
                        for (GymMember member : memberList) {
                            if (member instanceof RegularMember) {
                                RegularMember rm = (RegularMember) member;
                                fileWriter.write(String.format("%-5s %-17s %-15s %-10s %-15s %-15s %-25s %-25s %-15s %-15s %-15s %-20s %-15s %-20s %-20s\n",
                                    rm.getId(), rm.getName(), rm.getLocation(), rm.getGender(), rm.getDOB(),
                                    rm.getPhone(), rm.getEmail(), rm.getMembershipStartDate(), rm.getAttendance(), rm.getLoyaltyPoints(), rm.isActiveStatus(), rm.getPlan(), rm.getPrice(),
                                    rm.getReferralSource(), rm.getRemovalReason()));
                                
                            }
                        }
                        it = 1;
                        while(it < 260){
                            fileWriter.write("-");
                            it++;
                        }

                        fileWriter.close();

                       }
                    } catch (IOException ex) {
                        System.out.print("Error occurred, unable to write in file");
                    }
                }
                break;                
            default:
                break;
        }
       
        frame.revalidate(); // Refresh layout
        frame.repaint(); // Repaint UI
    }

    
    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel lbl = (JLabel) e.getSource(); 
        lbl.setForeground(Color.decode("#FFBB33"));
        lbl.setCursor(pointerCursor);

        if (lbl.getText().equals("!")) {
            regularPanel.add(rPricePanel);
            premiumPanel.add(pPricePanel);
            regularPanel.setComponentZOrder(rPricePanel, 0);
            premiumPanel.setComponentZOrder(pPricePanel, 0);
        }

        frame.revalidate(); // Refresh layout
        frame.repaint(); // Repaint UI
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        JLabel lbl = (JLabel) e.getSource();
        lbl.setForeground(Color.WHITE);

        if (lbl.getText().equals("!")) {
            regularPanel.remove(rPricePanel);
            premiumPanel.remove(pPricePanel);
        }
        frame.revalidate(); // Refresh layout
        frame.repaint(); // Repaint UI
    }
    
    @Override
    public void mousePressed(MouseEvent e) {}
    
    @Override
    public void mouseReleased(MouseEvent e) {}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //clear Button Event Handlling 
        if(e.getSource() == pClearBtn) {
            clearPremium();
            JOptionPane.showMessageDialog(frame, "Cleared Successful", "Clear", JOptionPane.INFORMATION_MESSAGE);
        }

        else if(e.getSource() == rClearBtn) {
            clearRegular();
            JOptionPane.showMessageDialog(frame, "Cleared Successful", "Clear", JOptionPane.INFORMATION_MESSAGE);
        }
        
        //save premium mrmber btn
        else if (e.getSource() == pSaveBtn) {
            //getting value of the inputs given by the user
            fpName = pNameTxt.getText();
            fpId = pIdTxt.getText();
            fpLocation = pLocationTxt.getText();
            if(pMale.isSelected()) {
                fpGender = "Male";
            }
            else if(pFemale.isSelected()) {
                fpGender = "Female";
            }
            else {
                fpGender = "";
            }
            String selectedDOByear = (String) DOByear.getSelectedItem();
            String selectedDOBmonth = (String) DOBmonth.getSelectedItem();
            String selectedDOBday = (String) DOBday.getSelectedItem();
            fpDOB = selectedDOByear+"-"+selectedDOBmonth+"-"+selectedDOBday;
            fpPhoneNo = pPhoneNoTxt.getText();
            fpEmail = pEmailTxt.getText();
            String selectedmembershipyear = (String) membershipyear.getSelectedItem();
            String selectedmembershipmonth = (String) membershipmonth.getSelectedItem();
            String selectedmembershipday = (String) membershipday.getSelectedItem();
            fpMembershipDate = selectedmembershipyear+"-"+selectedmembershipmonth+"-"+selectedmembershipday;
            
            fpPersonalTrainer = pPersonalTrainerTxt.getText();
            fpPaidAmount = pPaidAmountTxt.getText();
            if(fpName.trim().isEmpty() || fpId.trim().isEmpty() || fpLocation.trim().isEmpty() || fpGender.trim().isEmpty() || fpPhoneNo.trim().isEmpty()
                || fpEmail.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Empty Field Found","Error!" , JOptionPane.ERROR_MESSAGE);
            }
            else {
                if(!checkInteger(fpId) || !checkInteger(fpPhoneNo)) {
                    JOptionPane.showMessageDialog(frame, "Enter Integer only in required Fields", "", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    finalPId= Integer.parseInt(fpId);
                    if(fpPhoneNo.length() != 10) {
                        JOptionPane.showMessageDialog(frame, "Phone Number can be only of 10 digits", "", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        addPremium();
                        //sucess
                    } 
                }
            }
            
        }
        //for regular member
        else if (e.getSource() == rSaveBtn) {
            //getting value of the inputs given by the user
            frName = rNameTxt.getText();
            frId = rIdTxt.getText();
            frLocation = rLocationTxt.getText();
            //gender
            if(rMale.isSelected()) {
                frGender = "Male";
            }
            else if(rFemale.isSelected()) {
                frGender = "Female";
            }
            else {
                frGender = "";
            }
            //dob
            String selectedDOByear = (String) rDOByear.getSelectedItem();
            String selectedDOBmonth = (String) rDOBmonth.getSelectedItem();
            String selectedDOBday = (String) rDOBday.getSelectedItem();
            frDOB = selectedDOByear+"-"+selectedDOBmonth+"-"+selectedDOBday;
            
            frPhoneNo = rPhoneNoTxt.getText();
            frEmail = rEmailTxt.getText();
            //membership
            String selectedmembershipyear = (String) rmembershipyear.getSelectedItem();
            String selectedmembershipmonth = (String) rmembershipmonth.getSelectedItem();
            String selectedmembershipday = (String) rmembershipday.getSelectedItem();
            frMembershipDate = selectedmembershipyear+"-"+selectedmembershipmonth+"-"+selectedmembershipday;
            frReferalSource = rReferalSourceTxt.getText();
            //plan
            frPlan = (String) rPlanBox.getSelectedItem();
            if(frName.trim().isEmpty() || frId.trim().isEmpty() || frLocation.trim().isEmpty() || frGender.trim().isEmpty() || frPhoneNo.trim().isEmpty()
                ||  frEmail.trim().isEmpty() || frReferalSource.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Empty Field Found","Error!" , JOptionPane.ERROR_MESSAGE);
            }
            else {
                if(!checkInteger(frId) || !checkInteger(frPhoneNo)) {
                    JOptionPane.showMessageDialog(frame, "Enter Integer only in required Fields", "", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    finalRId= Integer.parseInt(frId);
                    if(frPhoneNo.length() != 10) {
                        JOptionPane.showMessageDialog(frame, "Phone Number can be only of 10 digits", "", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        addRegular();
                    }                    
                }
            }
        }

        //for activate membership button
        else if (e.getSource() == pActivate) {
            int resultId = memberControlLabel();
            if(resultId == 0) {
                JOptionPane.showMessageDialog(frame, "Enter valid ID!", "Invalid ID", JOptionPane.WARNING_MESSAGE);
            }
            else {
                if(memberList.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ID not Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    boolean found = false;
                    
                    for (GymMember member : memberList) {

                        if(member.getId() == resultId && member instanceof PremiumMember) {
                            found = true;
                            if(member.isActiveStatus()) {
                                JOptionPane.showMessageDialog(frame, "Membership is already Activated", "Message", JOptionPane.QUESTION_MESSAGE);
                            }
                            else {
                                member.activeMembership();
                                JOptionPane.showMessageDialog(frame, "Activated Membership");
                            }
                            break;
                        }
                    }
                    
                    if(!found) {
                            JOptionPane.showMessageDialog(frame, "ID not Found, or not a Premium Member", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        
        else if (e.getSource() == rActivate) {
            int resultId = memberControlLabel();
            if(resultId == 0) {
                JOptionPane.showMessageDialog(frame, "Enter valid ID!", "Invalid ID", JOptionPane.WARNING_MESSAGE);
            }
            else {
                if(memberList.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ID not Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    boolean found = false;
                    
                    for (GymMember member : memberList) {

                        if(member.getId() == resultId && member instanceof RegularMember) {
                            found = true;
                            if(member.isActiveStatus()) {
                                JOptionPane.showMessageDialog(frame, "Membership is already Activated", "Message", JOptionPane.QUESTION_MESSAGE);
                            }
                            else {
                                member.activeMembership();
                                JOptionPane.showMessageDialog(frame, "Activated Membership");
                            }
                            break;
                        }
                    }
                    
                    if(!found) {
                            JOptionPane.showMessageDialog(frame, "ID not Found, or not a regular member", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        
        //for deactivate membership button
        else if (e.getSource() == pDeactivate) {
            int resultId = memberControlLabel();
            if(resultId == 0) {
                JOptionPane.showMessageDialog(frame, "Enter valid ID!", "Invalid ID", JOptionPane.WARNING_MESSAGE);
            }
            else {
                if(memberList.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ID not Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    boolean found = false;
                    
                    for (GymMember member : memberList) {

                        if(member.getId() == resultId && member instanceof PremiumMember) {
                            found = true;
                            if(member.isActiveStatus()) {
                                member.deactiveMembership(member.isActiveStatus());
                                JOptionPane.showMessageDialog(frame, "Deactivated Membership");
                            }
                            else {
                                JOptionPane.showMessageDialog(frame, "Membership is already Deactivated", "Message", JOptionPane.QUESTION_MESSAGE);
                            }
                            break;
                        }
                    }
                    
                    if(!found) {
                            JOptionPane.showMessageDialog(frame, "ID not Found, or not a premium member", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        
        else if (e.getSource() == rDeactivate) {
            int resultId = memberControlLabel();
            if(resultId == 0) {
                JOptionPane.showMessageDialog(frame, "Enter valid ID!", "Invalid ID", JOptionPane.WARNING_MESSAGE);
            }
            else {
                if(memberList.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ID not Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    boolean found = false;
                    
                    for (GymMember member : memberList) {

                        if(member.getId() == resultId && member instanceof RegularMember) {
                            found = true;
                            if(member.isActiveStatus()) {
                                member.deactiveMembership(member.isActiveStatus());
                                JOptionPane.showMessageDialog(frame, "Deactivated Membership");
                            }
                            else {
                                JOptionPane.showMessageDialog(frame, "Membership is already Deactivated", "Message", JOptionPane.QUESTION_MESSAGE);
                            }
                            break;
                        }
                    }
                    
                    if(!found) {
                            JOptionPane.showMessageDialog(frame, "ID not Found, or not a Regular Member", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        
        // for mark attendance Button
        else if (e.getSource() == pMarkAttendance) {
            int resultId = memberControlLabel();
            if(resultId == 0) {
                JOptionPane.showMessageDialog(frame, "Enter valid ID!", "Invalid ID", JOptionPane.WARNING_MESSAGE);
            }
            else {
                if(memberList.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ID not Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    boolean found = false;
                    
                    for (GymMember member : memberList) {

                        if(member.getId() == resultId && member instanceof PremiumMember) {
                            found = true;
                            if(member.isActiveStatus()) {
                                member.markAttendance();
                                JOptionPane.showMessageDialog(frame, "Marked Attendance");
                            }
                            else {
                                JOptionPane.showMessageDialog(frame, "Membership is Deactivated", "Message", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
                        }
                    }
                    
                    if(!found) {
                            JOptionPane.showMessageDialog(frame, "ID not Found, or not a PremiumMember", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        
        else if (e.getSource() == rMarkAttendance) {
            int resultId = memberControlLabel();
            if(resultId == 0) {
                JOptionPane.showMessageDialog(frame, "Enter valid ID!", "Invalid ID", JOptionPane.WARNING_MESSAGE);
            }
            else {
                if(memberList.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ID not Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    boolean found = false;
                    
                    for (GymMember member : memberList) {

                        if(member.getId() == resultId && member instanceof RegularMember) {
                            found = true;
                            if(member.isActiveStatus()) {
                                member.markAttendance();
                                JOptionPane.showMessageDialog(frame, "Marked Attendance");
                            }
                            else {
                                JOptionPane.showMessageDialog(frame, "Membership is Deactivated", "Message", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
                        }
                    }
                    
                    if(!found) {
                            JOptionPane.showMessageDialog(frame, "ID not Found, or not a Regular Member", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        
        // for revert premium member button
        else if (e.getSource() == pRevert) {
            int resultId = memberControlLabel();

            if (memberList.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "ID not Found", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                boolean got = false;
            
                for (GymMember member : memberList) {
                    if (member.getId() == resultId && member instanceof PremiumMember) {
                        pm.revertPremiumMember(); // or member.revertPremiumMember() if applicable
                        JOptionPane.showMessageDialog(frame, "Member Reverted");
                        got = true;
                        break;
                    }
                }
            
                if (!got) {
                    JOptionPane.showMessageDialog(frame, "ID not Found, or not a Premium Member", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        // for revert regular member button
        else if (e.getSource() == rRevert) {
            
            int resultId = memberControlLabel(); //calling memberControlLabel() method 
            if(memberList.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "ID not Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {   
                for (GymMember member : memberList) {
                    if(member.getId() == resultId && member instanceof RegularMember) {
                        String removalReason = JOptionPane.showInputDialog("Removal Reason:");
                        if(removalReason.trim() != "") {
                            rm.revertRegularMember(removalReason);
                            JOptionPane.showMessageDialog(frame, "Member Reverted");
                            return;
                        }
                        else {
                            JOptionPane.showMessageDialog(frame, "Removal Reason missing", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        } 
                    }
                }
                JOptionPane.showMessageDialog(frame, "ID not Found, or not a regular member", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if (e.getSource() == payDueAmountBtn) {
        int id = 0;
        double amt = 0;
            
        String resultIdText = financeSearchField.getText().trim();
        String amtText = enterAmtField.getText().trim();
            
        if (checkInteger(resultIdText)) {
            id = Integer.parseInt(resultIdText);
            
            if (checkInteger(amtText)) {
                amt = Integer.parseInt(amtText);
                 
                if (amt > 0) {
                    if(memberList.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "ID not Found", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    else {
                        boolean got = false;
                        for (GymMember member : memberList) {
                            if(member.getId() == id && member instanceof PremiumMember) {
                                String returntext = pm.payDueAmount(amt);
                                JOptionPane.showMessageDialog(frame, returntext, "Information", JOptionPane.INFORMATION_MESSAGE);
                                got = true;
                                break;
                            }
                        }
                            
                        if(!got) {
                            JOptionPane.showMessageDialog(frame, "Id not found, or a Regular Member", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Enter valid amount!", "", JOptionPane.WARNING_MESSAGE);
                }
            }
                
            else {
                JOptionPane.showMessageDialog(frame, "Enter valid amount!", "", JOptionPane.WARNING_MESSAGE);
            }
        }
            else {
                JOptionPane.showMessageDialog(frame, "Enter Valid Id!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if (e.getSource() == calculateDiscountBtn) {
            int id = 0;
            // System.out.println("Works");
            String resultIdText = financeSearchField.getText().trim();
            if (checkInteger(resultIdText)) {
                id = Integer.parseInt(resultIdText);
                if(memberList.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ID not Found", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                else {
                    boolean got = false;
                    for (GymMember member : memberList) {
                        if(member.getId() == id && member instanceof PremiumMember) {
                            pm.calculateDiscount();
                            if(pm.getDiscountAmount() > 0) {
                                JOptionPane.showMessageDialog(frame, "Discount Received 10%\nDiscounted amount 5000.00", "Discount", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else {
                                JOptionPane.showMessageDialog(frame, "Discount Received 0%\nDiscounted amount 0.00", "Discount", JOptionPane.INFORMATION_MESSAGE);
                            }
                            got = true;
                            break;
                        }
                    }
                    
                    if(!got) {
                            JOptionPane.showMessageDialog(frame, "Id not found, or a Regular Member", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                }
            }
            else {
                JOptionPane.showMessageDialog(frame, "Enter Valid Id!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if (e.getSource() == upgradePlanBtn){
            String planText = financePlan.getSelectedItem().toString();
            int id = 0;
            // System.out.println("Works");
            String resultIdText = financeSearchField.getText().trim();
            if (checkInteger(resultIdText)) {
                id = Integer.parseInt(resultIdText);
                if(memberList.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ID not Found", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                else {
                    boolean got = false;
                    for (GymMember member : memberList) {
                        if(member.getId() == id && member instanceof RegularMember) {
                            String returnTxt = rm.updatePlan(planText);
                            JOptionPane.showMessageDialog(frame, returnTxt, "Information", JOptionPane.INFORMATION_MESSAGE);
                            got = true;
                            break;
                        }
                    }
                    
                    if(!got) {
                            JOptionPane.showMessageDialog(frame, "Id not found, or a Premium Member", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                }
            }
            else {
                JOptionPane.showMessageDialog(frame, "Enter Valid Id!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else if (e.getSource() == dSearchBtn){
            //Works
            String displayID = displaySearchTxt.getText();
            int id;
            if (checkInteger(displayID)) {
                id = Integer.parseInt(displayID);
                displaySearchTxt.setText("");
                //works
                if(memberList.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ID not Found", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else {
                    boolean got = false;
                    for (GymMember member : memberList) {
                        if(member.getId() == id && member instanceof PremiumMember) {
                            member.display();
                            dName.setText("Name: "+member.getName());
                            dId.setText("Id: "+member.getId());
                            dLocation.setText("Location: "+member.getLocation());
                            dGender.setText("Gender: "+member.getGender());
                            dDob.setText("Date of Birth: "+member.getDOB());
                            dPhone.setText("Phone number: "+member.getPhone());
                            dEmail.setText("Email: "+member.getEmail());
                            dMembershipDate.setText("Membership start Date: "+member.getMembershipStartDate());
                            dAttendance.setText("Attendance: "+member.getAttendance());
                            dLoyaltyPoints.setText("Loyalty Points: "+member.getLoyaltyPoints());
                            dActiveStatus.setText("Active Status: "+member.isActiveStatus());
                            dPersonalTrainer.setText("Personal Trainer: "+pm.getPersonalTrainer());
                            if(pm.getIsFullPayment()) {
                                dPaidAmount.setText("Paid Amount: "+(pm.getPaidAmount() - pm.getDiscountAmount()));
                            }
                            else {
                                dPaidAmount.setText("Paid Amount: "+pm.getPaidAmount());
                            }
                            dRemainingAmount.setText("Remaning Amount: "+(50000.00d-pm.getPaidAmount()));
                            dDiscount.setText("Discount: "+pm.getDiscountAmount());
                            got = true;
                            break;
                        }
                        else if(member.getId() == id && member instanceof RegularMember) {
                            dName.setText("Name: "+member.getName());
                            dId.setText("Id: "+member.getId());
                            dLocation.setText("Location: "+member.getLocation());
                            dGender.setText("Gender: "+member.getGender());
                            dDob.setText("Date of Birth: "+member.getDOB());
                            dPhone.setText("Phone number: "+member.getPhone());
                            dEmail.setText("Email: "+member.getEmail());
                            dMembershipDate.setText("Membership start Date: "+member.getMembershipStartDate());
                            dAttendance.setText("Attendance: "+member.getAttendance());
                            dLoyaltyPoints.setText("Loyalty Points: "+member.getLoyaltyPoints());
                            dActiveStatus.setText("Active Status: "+member.isActiveStatus());
                            dPersonalTrainer.setText("Plan: "+rm.getPlan());
                            dPaidAmount.setText("Price: "+rm.getPlanPrice(rm.getPlan()));
                            dRemainingAmount.setText("Referral Source: "+rm.getReferralSource());
                            if(rm.getRemovalReason() == "") {
                                dDiscount.setText("");
                                System.out.println("removal Reason");
                            }
                            else {
                                dDiscount.setText("Removal Reason: " + rm.getRemovalReason());
                            }
                            got = true;
                            break;
                        }                        
                    }
                    if (!got) {
                        JOptionPane.showMessageDialog(frame, "ID not Found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(frame,"Enter Valid Id!", "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public int memberControlLabel() {
        String text = searchTxt.getText().trim();
        int id = 0;
        if(checkInteger(text)) {
            id = Integer.parseInt(text);
        }
        return id;
    }
    
    //method to check whether given number is integer or not
    public boolean checkInteger(String num) {
        try {
            Long.parseLong(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
        public void clearPremium() {
        pNameTxt.setText("");
        pIdTxt.setText("");
        pLocationTxt.setText("");
        pPhoneNoTxt.setText("");
        pEmailTxt.setText("");
        pPersonalTrainerTxt.setText("");
        pPaidAmountTxt.setText("");
        pGroup.clearSelection();
        DOByear.setSelectedIndex(0);
        DOBmonth.setSelectedIndex(0);
        DOBday.setSelectedIndex(0);
        membershipyear.setSelectedIndex(0);
        membershipmonth.setSelectedIndex(0);
        membershipday.setSelectedIndex(0);        
    }
    
    public void clearRegular() {
        rNameTxt.setText("");
        rIdTxt.setText("");
        rLocationTxt.setText("");
        rPhoneNoTxt.setText("");
        rEmailTxt.setText("");
        rReferalSourceTxt.setText("");
        pPaidAmountTxt.setText("");
        rGroup.clearSelection();
        rDOByear.setSelectedIndex(0);
        rDOBmonth.setSelectedIndex(0);
        rDOBday.setSelectedIndex(0);
        rmembershipyear.setSelectedIndex(0);
        rmembershipmonth.setSelectedIndex(0);
        rmembershipday.setSelectedIndex(0);
        rPlanBox.setSelectedIndex(0);       
    }
    
    public static void main(String[] args)
    {
        GymGui gui = new GymGui();
    }
    
    //arraylist created
    ArrayList<GymMember> memberList = new ArrayList<>();
    PremiumMember pm;
    RegularMember rm;
    public void addPremium() {
        pm = new PremiumMember(finalPId,fpName, fpLocation, fpPhoneNo, fpEmail, fpGender, fpDOB, fpMembershipDate, fpPersonalTrainer);
        boolean exists = false;
        
        if(memberList.isEmpty()) {
            memberList.add(pm);
            JOptionPane.showMessageDialog(frame, "Saved Successfully", "", JOptionPane.INFORMATION_MESSAGE);
            clearPremium();
        }
        else {
            for (GymMember member: memberList) {
                if(finalPId == member.getId()) {
                    exists = true;
                }
                
            }
            if(exists) {
                JOptionPane.showMessageDialog(frame, finalPId+" is already reserved!", "", JOptionPane.WARNING_MESSAGE);
            }
            else {
                memberList.add(pm);
                JOptionPane.showMessageDialog(frame, "Saved Successfully", "", JOptionPane.INFORMATION_MESSAGE);
                clearPremium();
            }
        }
    }
    
    public void addRegular() {
        rm = new RegularMember(finalRId,frName, frLocation, frPhoneNo, frEmail, frGender, frDOB, frMembershipDate, frReferalSource);
        boolean exists = false;
        
        if(memberList.isEmpty()) {
            memberList.add(rm);
            JOptionPane.showMessageDialog(frame, "Saved Successfully", "", JOptionPane.INFORMATION_MESSAGE);
            clearRegular();
        }
        else {
            for (GymMember member : memberList) {
                if(finalRId == member.getId()) {
                    exists = true;
                }
            }
            
            if(exists) {
                JOptionPane.showMessageDialog(frame, finalRId+" is already reserved!", "", JOptionPane.WARNING_MESSAGE);
            }
            else {            
                memberList.add(rm);
                JOptionPane.showMessageDialog(frame, "Saved Successfully", "", JOptionPane.INFORMATION_MESSAGE);
                clearRegular();
            }
        }
    }
}