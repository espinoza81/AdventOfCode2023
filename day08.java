import java.util.*;

public class day08 {
    public static void main(String[] args) {
        char[] instructions = INPUT.substring(0, INPUT.indexOf("\n")).toCharArray();
        HashMap<String, List<String>> destinations = new HashMap<>();
        Arrays.stream(INPUT.substring(INPUT.indexOf("\n")).trim().split("\n"))
                .forEach(s -> {
                    String start = s.substring(0, 3);
                    String left = s.substring(7, 10);
                    String right = s.substring(12, 15);
                    List<String> directions = new ArrayList<>();
                    directions.add(left);
                    directions.add(right);
                    destinations.put(start, directions);

                });
        int circle = 0;
        int steps = 0;
        String start = "AAA";

        while (true){
            for (char instruction : instructions) {
                if (instruction == 'L') {
                    start = destinations.get(start).get(0);
                } else {
                    start = destinations.get(start).get(1);
                }
                steps++;
                if (start.endsWith("Z")) {
                    if (circle==2) {
                        System.out.println(steps);
                        return;
                    } else {
                        circle++ ;
                    }
                }
            }
        }
    }

    private static final String EXAMPLE =
            """
                    LLR

                    AAA = (BBB, BBB)
                    BBB = (AAA, ZZZ)
                    ZZZ = (ZZZ, ZZZ)""";

    public static String INPUT =
            """
                    LLLRRLRRRLLRRLRRLLRLRRLRRRLRRLRRLRRRLRLRRLRLRRLRRLLRRLRLLRRLLLRRRLRRLRLRLRRRLRLLRRLRRRLRRLRRLRRLRLLRLLRRLRRRLRRLRLRRLRRRLRRLLRLLRRLRRRLLRRRLRLRRRLLRLRRLRRLLRRLRRLLLRRRLRLRRRLRRLLRLRRLRLLRRRLRLRLLRLRRRLRLRRRLRRLRLRLLRLRRRLRRLRRRLRRRLRLRRRLRRRLLLLRLRLRRRLLLRLRRRLRRLRLRRLLRLLRRRR

                    FSH = (CGN, NDK)
                    LQT = (NSK, XBG)
                    LCP = (QQB, NTB)
                    DFG = (KTV, NJR)
                    MCC = (TRF, NHH)
                    PHG = (VMX, SHB)
                    SMP = (MKD, TBS)
                    MRT = (NJX, HHJ)
                    LNG = (KRF, VDK)
                    TKG = (VLM, XFQ)
                    QCR = (BDL, VKQ)
                    PQC = (CXK, HKS)
                    DQR = (LRS, CCF)
                    XVP = (MSP, DVD)
                    JGN = (DJF, QCP)
                    QCP = (MLF, CPS)
                    CNJ = (NLQ, BJD)
                    DPR = (CVL, NSB)
                    VKQ = (PGL, LRK)
                    XGF = (DBG, NSG)
                    TXH = (JQJ, XHN)
                    PHR = (SRD, HVS)
                    FXF = (KGG, QCV)
                    DXK = (RQB, GTX)
                    PKC = (KQP, SMT)
                    SHX = (VDF, RFP)
                    JSQ = (BHM, TCJ)
                    LQS = (GDD, FJT)
                    XVJ = (DTL, BKR)
                    TJF = (XKG, BTD)
                    KMP = (TQL, CFV)
                    VBV = (BJL, DHL)
                    JXR = (PKD, BKV)
                    TBN = (TGK, BLP)
                    PQD = (MCC, QDF)
                    KRF = (VSB, JXQ)
                    RNJ = (JGN, NJH)
                    HVR = (JXK, SMH)
                    DML = (MHP, SBL)
                    HJH = (KGR, TXH)
                    JCF = (GBJ, GBJ)
                    SKX = (VVX, SNX)
                    SPS = (VCS, RKK)
                    MJD = (SSL, VKM)
                    TMG = (CNN, XTJ)
                    BBM = (QGJ, LJL)
                    MFV = (XPC, BCC)
                    SCD = (QLG, BCB)
                    QGQ = (MPV, SMP)
                    DQS = (QSN, NSV)
                    GTN = (BGF, NBD)
                    JDG = (GRX, CLV)
                    PMM = (HGP, SBS)
                    GHV = (CNC, NJQ)
                    RBG = (CGN, NDK)
                    MXL = (XXQ, KQD)
                    KQQ = (CBL, LXX)
                    BVT = (CFS, TPH)
                    DFD = (FKV, MVK)
                    CJV = (GTN, JNH)
                    PGF = (XNS, CNJ)
                    JTF = (BQS, HMG)
                    XXB = (NXF, NVF)
                    GDD = (HQB, DPR)
                    KTT = (TGT, XGF)
                    DCR = (LNG, HLF)
                    FVQ = (JQT, DFN)
                    DTX = (RDB, CHV)
                    PPB = (PQC, XVR)
                    NJK = (DXK, HTV)
                    DQN = (LNL, GBK)
                    GCP = (RTJ, XQL)
                    DHR = (KCS, KVP)
                    HNQ = (GPC, MNL)
                    RDV = (FQN, GNB)
                    NSG = (FLM, PCD)
                    LJL = (XVP, LHX)
                    HVD = (CML, CPT)
                    HGN = (LRS, CCF)
                    GGS = (FCS, VKS)
                    PHV = (SJF, SJF)
                    NLH = (BJJ, XKX)
                    XXQ = (VTP, XDK)
                    KHL = (BJL, DHL)
                    DKG = (CLV, GRX)
                    HQX = (KGH, BXP)
                    RGC = (PTM, QPV)
                    LVJ = (TVV, TVV)
                    PNG = (XCR, NTV)
                    XCM = (FQN, GNB)
                    QRV = (XMS, XTG)
                    DJF = (MLF, CPS)
                    XJG = (MQS, QHX)
                    BRD = (KCS, KVP)
                    DDM = (DMF, KBX)
                    GKP = (JMV, TBN)
                    MTV = (GTN, JNH)
                    KGM = (GRF, VTM)
                    SNX = (PRG, CGT)
                    DXT = (GRF, VTM)
                    SXT = (FKX, MNM)
                    XPL = (TPH, CFS)
                    NJH = (QCP, DJF)
                    MJX = (TDB, SHX)
                    JJR = (DTL, BKR)
                    SLB = (NXM, XLT)
                    NSV = (QBD, MHT)
                    XXH = (BSF, KLF)
                    FMG = (XCM, RDV)
                    RKK = (RNR, BVR)
                    VQJ = (TBR, NQG)
                    QRR = (VPP, TDH)
                    GLF = (PPD, VRF)
                    PKT = (PHT, TPR)
                    KVP = (LFH, LTQ)
                    DSQ = (VTJ, FBN)
                    LXL = (GXR, KTT)
                    AAA = (LBL, QGQ)
                    QQT = (PXM, DBS)
                    PRG = (FMN, XXD)
                    NXF = (KQN, HHK)
                    XPC = (GKP, XSB)
                    SKP = (MLR, GGS)
                    BMD = (QSN, NSV)
                    VKL = (BCC, XPC)
                    FCC = (QCR, DSS)
                    XSB = (TBN, JMV)
                    MTD = (JTF, SHN)
                    TJX = (TGM, HJH)
                    HTV = (RQB, GTX)
                    HCB = (BSF, KLF)
                    FXK = (PHV, TCN)
                    XDK = (DFG, SXH)
                    SSL = (XTV, CXM)
                    PPH = (XXQ, KQD)
                    MGC = (NHB, FTM)
                    CPS = (MML, JHQ)
                    KKJ = (DQR, HGN)
                    RKH = (LKL, FKD)
                    MCG = (JQQ, CLG)
                    RLD = (PQD, CNV)
                    PCV = (QVL, DNF)
                    LQV = (THB, LXV)
                    DQH = (FSN, GHZ)
                    MPV = (MKD, TBS)
                    HGB = (LXV, THB)
                    DBG = (FLM, PCD)
                    GSC = (FSR, TRM)
                    NCF = (LXL, MVN)
                    XBJ = (CHQ, MXM)
                    TNN = (NQG, TBR)
                    PVF = (XVS, XDM)
                    QCL = (QRS, LQC)
                    PGL = (JCK, DKH)
                    XQN = (LNG, HLF)
                    RQB = (SNR, LPL)
                    DFM = (GLV, NHG)
                    BNN = (MMX, DPK)
                    VSF = (HVR, FVG)
                    PFJ = (TNK, NVJ)
                    BKX = (RKK, VCS)
                    QBL = (PKT, RBJ)
                    HBC = (FSR, TRM)
                    DVM = (QVL, DNF)
                    DPK = (VBG, RKF)
                    SMH = (TTV, VCK)
                    GBK = (PXL, DHH)
                    XDJ = (MFV, VKL)
                    VMN = (VGJ, NQT)
                    HHJ = (PVL, RHR)
                    FND = (XHS, VHF)
                    DLV = (VSF, DFV)
                    NBK = (GMR, NXJ)
                    CSX = (JCX, VMG)
                    FDB = (VHK, SCB)
                    VKM = (CXM, XTV)
                    SXH = (NJR, KTV)
                    HXZ = (FJR, SKP)
                    JXN = (MDL, FCC)
                    KLS = (FXF, LPQ)
                    NVF = (KQN, HHK)
                    QXP = (KLS, KFS)
                    XMX = (KKJ, CLH)
                    KXV = (MHP, SBL)
                    TBR = (NVS, PGF)
                    MXN = (VBP, RMJ)
                    RCX = (KGM, DXT)
                    BJD = (KRB, HNQ)
                    KVJ = (HVD, QXX)
                    BQS = (HCK, THS)
                    KGR = (XHN, JQJ)
                    GDV = (TRP, MXF)
                    TPR = (XVL, SKX)
                    KJC = (TRB, VRJ)
                    CNV = (MCC, QDF)
                    QPG = (BSR, GGL)
                    SHQ = (VLM, XFQ)
                    VTM = (JKN, GJJ)
                    MPB = (NTV, XCR)
                    JQQ = (DPX, GHJ)
                    PVL = (DKQ, FJN)
                    PCD = (KMF, FTP)
                    PPK = (PVF, XLN)
                    GRX = (GVD, HQP)
                    GQP = (VGJ, NQT)
                    VMG = (LPF, RNJ)
                    GHZ = (FTX, DQN)
                    VSB = (PBP, LKF)
                    VLM = (GMX, LVP)
                    VHG = (FCC, MDL)
                    SBS = (RSF, FHP)
                    QFJ = (VDC, NCF)
                    CKR = (FJT, GDD)
                    CBK = (TMK, GJB)
                    BBN = (MJL, BBR)
                    XCX = (MLN, QRR)
                    GXR = (TGT, XGF)
                    HLF = (VDK, KRF)
                    RDP = (CJN, BBN)
                    QJL = (PNT, CRC)
                    SHN = (BQS, HMG)
                    DMD = (DLV, KVB)
                    XRL = (LVF, XFL)
                    HCK = (RKJ, FNJ)
                    PXM = (XVM, LTM)
                    GQT = (JKK, SLQ)
                    TPZ = (HGB, LQV)
                    GBJ = (LQV, HGB)
                    CFV = (STD, CSK)
                    FTP = (TKG, SHQ)
                    TVJ = (HVS, SRD)
                    CQC = (NCK, LMV)
                    FQN = (FSH, RBG)
                    FRQ = (KLQ, QRV)
                    XLN = (XDM, XVS)
                    VHX = (PLN, TXM)
                    DTV = (PKD, BKV)
                    NBD = (TLB, FRQ)
                    NSJ = (CFH, PXP)
                    FCS = (GHV, JBR)
                    BML = (TCJ, BHM)
                    PTM = (XGG, FDS)
                    XQL = (QNH, THK)
                    QDF = (TRF, NHH)
                    MHT = (QRN, BNN)
                    LJB = (FQC, GNQ)
                    QFK = (LPR, QJL)
                    NHK = (XLT, NXM)
                    TXM = (MFR, GDV)
                    TMK = (NMD, RQF)
                    GKF = (JXR, DTV)
                    LXX = (LVJ, SQH)
                    XVR = (CXK, HKS)
                    XCG = (QJL, LPR)
                    NJR = (TDL, GSK)
                    VTP = (DFG, SXH)
                    DBS = (XVM, LTM)
                    VMX = (SSM, PLS)
                    SCB = (BPH, MFF)
                    MLN = (TDH, VPP)
                    QXM = (VRF, PPD)
                    LKL = (NDX, DKT)
                    CPF = (FTM, NHB)
                    JLG = (FKN, GCP)
                    RDK = (QRR, MLN)
                    VCS = (BVR, RNR)
                    XKX = (TMJ, DQD)
                    THS = (RKJ, FNJ)
                    QQB = (SKR, VGH)
                    NQG = (NVS, PGF)
                    NTB = (VGH, SKR)
                    MXF = (HMC, NJK)
                    LXT = (CNV, PQD)
                    LTM = (QDL, KMP)
                    LNJ = (STT, FXL)
                    HKL = (CBL, CBL)
                    QGD = (KXJ, FXK)
                    JCX = (LPF, RNJ)
                    TRB = (TNN, VQJ)
                    QBD = (QRN, BNN)
                    JQJ = (DXL, MJX)
                    CLH = (DQR, HGN)
                    MXM = (RKH, LKT)
                    PTP = (XCG, QFK)
                    LVP = (GJX, NRP)
                    DKQ = (NTL, NNR)
                    FBS = (HGP, SBS)
                    BPH = (PMX, RDP)
                    FJR = (GGS, MLR)
                    GSX = (XBJ, TMB)
                    KTV = (TDL, GSK)
                    CHQ = (RKH, LKT)
                    TGK = (KVD, NNS)
                    LKT = (LKL, FKD)
                    RFP = (NSS, JFK)
                    FJC = (GQV, GKG)
                    RSF = (GSX, LFN)
                    FQZ = (SGP, NBK)
                    NJA = (SKP, FJR)
                    TRM = (MHK, DPH)
                    QNH = (PPK, FTL)
                    QNP = (FVQ, SRQ)
                    XLT = (TRN, QFJ)
                    VRJ = (TNN, VQJ)
                    GQV = (KRJ, RCX)
                    SKG = (FKP, KPD)
                    GLV = (VCJ, SJM)
                    GJX = (JLG, FSV)
                    FMN = (CRX, JLS)
                    DHJ = (KRM, NCN)
                    QDL = (CFV, TQL)
                    NBQ = (JHP, XXB)
                    GLC = (VJK, NBN)
                    DHH = (SVN, KVJ)
                    CRX = (CRJ, CRJ)
                    DQD = (KFP, VQM)
                    SKR = (CHN, GQL)
                    NBN = (JLJ, JQF)
                    HNR = (NJX, HHJ)
                    XTG = (VHG, JXN)
                    XXD = (CRX, JLS)
                    TQL = (CSK, STD)
                    SQH = (TVV, FQZ)
                    TMB = (MXM, CHQ)
                    CCF = (RVJ, PQR)
                    XTJ = (KQS, LJB)
                    DNF = (QTK, JLV)
                    XTV = (PHR, TVJ)
                    JXQ = (LKF, PBP)
                    FBN = (LXR, PPB)
                    LNS = (TGM, HJH)
                    LPC = (FND, KKG)
                    NDK = (CSV, HVK)
                    KRJ = (DXT, KGM)
                    FKP = (XGN, SCD)
                    FDS = (PNG, MPB)
                    NQB = (LPP, BNJ)
                    GNQ = (MCG, LKM)
                    LHX = (DVD, MSP)
                    FTM = (GLF, QXM)
                    RDB = (QRF, CBK)
                    CNN = (KQS, LJB)
                    FNC = (GKH, ZZZ)
                    RBJ = (TPR, PHT)
                    KBX = (DKF, HXZ)
                    NCK = (PPH, MXL)
                    DSS = (VKQ, BDL)
                    HVS = (CLP, QJR)
                    LNL = (DHH, PXL)
                    NDX = (NBQ, QTR)
                    MLR = (FCS, VKS)
                    PMX = (CJN, BBN)
                    HHK = (GKF, DSV)
                    SVN = (QXX, HVD)
                    TGT = (DBG, NSG)
                    XKG = (XRL, CPX)
                    QCV = (PFJ, NPS)
                    TRP = (HMC, NJK)
                    SQG = (GGL, BSR)
                    FTX = (LNL, GBK)
                    CJN = (BBR, MJL)
                    VRF = (XDJ, CXV)
                    VTJ = (PPB, LXR)
                    XTS = (NXG, CQC)
                    BHR = (HKL, KQQ)
                    HMK = (SLQ, JKK)
                    NHG = (SJM, VCJ)
                    QNR = (HNR, MRT)
                    KPD = (XGN, SCD)
                    BTD = (XRL, CPX)
                    NJX = (PVL, RHR)
                    FSV = (GCP, FKN)
                    MKL = (FBN, VTJ)
                    TRN = (NCF, VDC)
                    NMD = (XSS, XTF)
                    FSN = (DQN, FTX)
                    TTV = (RLD, LXT)
                    JCK = (BQB, DMD)
                    BXG = (SSL, VKM)
                    FGC = (BQN, GXF)
                    VCJ = (XPL, BVT)
                    QGJ = (XVP, LHX)
                    VHK = (BPH, MFF)
                    CGN = (CSV, HVK)
                    SKJ = (QPV, PTM)
                    CFS = (TJF, DVX)
                    JJP = (KFS, KLS)
                    XMS = (JXN, VHG)
                    QRF = (GJB, TMK)
                    THK = (PPK, FTL)
                    RKJ = (SRC, VJM)
                    KQD = (XDK, VTP)
                    CLG = (DPX, GHJ)
                    KVD = (HCB, XXH)
                    XCR = (QCL, KDK)
                    BSR = (BXG, MJD)
                    GDS = (KGH, BXP)
                    GMR = (FFF, JTK)
                    VVX = (PRG, CGT)
                    PCJ = (PCV, DVM)
                    TCJ = (KCD, LPC)
                    PKD = (CJV, MTV)
                    DPH = (BDJ, RXP)
                    CGT = (FMN, XXD)
                    TTL = (FKX, MNM)
                    CBL = (LVJ, LVJ)
                    LFN = (XBJ, TMB)
                    NHB = (GLF, QXM)
                    FNJ = (SRC, VJM)
                    FLM = (KMF, FTP)
                    FTL = (XLN, PVF)
                    TPH = (TJF, DVX)
                    BSF = (NSJ, JLP)
                    JBR = (CNC, NJQ)
                    PXP = (SGJ, SXG)
                    LRS = (RVJ, PQR)
                    XVL = (SNX, VVX)
                    SBL = (FNB, NLH)
                    HXH = (FKP, KPD)
                    JFK = (QVX, DHJ)
                    GKG = (RCX, KRJ)
                    DHL = (JDG, DKG)
                    NSB = (FJC, DXN)
                    SJF = (JCF, JCF)
                    STD = (VBV, KHL)
                    NSS = (DHJ, QVX)
                    GPC = (JDH, JDH)
                    RPS = (JCF, GQS)
                    MMM = (SKJ, RGC)
                    XFQ = (GMX, LVP)
                    KXJ = (PHV, TCN)
                    JLS = (CRJ, SLM)
                    QLB = (DMF, DMF)
                    NNR = (KJC, NGJ)
                    KRM = (DML, KXV)
                    DKH = (BQB, DMD)
                    CHV = (QRF, CBK)
                    PHT = (XVL, SKX)
                    MVN = (KTT, GXR)
                    SFB = (DLD, FMG)
                    FNM = (MRT, HNR)
                    HMG = (THS, HCK)
                    XNS = (NLQ, BJD)
                    CLV = (HQP, GVD)
                    MMX = (RKF, VBG)
                    BVR = (SLB, NHK)
                    LRP = (GXF, BQN)
                    GNB = (FSH, RBG)
                    JQF = (CLD, QQT)
                    HMC = (HTV, DXK)
                    TRF = (LNS, TJX)
                    HQB = (NSB, CVL)
                    TVV = (NBK, SGP)
                    GHJ = (JJR, XVJ)
                    KCS = (LFH, LTQ)
                    LPR = (CRC, PNT)
                    JXK = (TTV, VCK)
                    KFS = (LPQ, FXF)
                    TXR = (DTX, GCR)
                    BQN = (QBL, DPD)
                    VNL = (DTX, GCR)
                    CXV = (MFV, VKL)
                    GKN = (FNM, QNR)
                    BTJ = (LPP, BNJ)
                    PBP = (SFB, HSG)
                    CVL = (FJC, DXN)
                    RXP = (DHV, PVZ)
                    XVM = (QDL, KMP)
                    XVS = (CMF, PKH)
                    BQB = (DLV, KVB)
                    QLG = (LTD, XJG)
                    HVK = (KSF, CVV)
                    DTL = (HBC, GSC)
                    BHA = (DQN, FTX)
                    MHP = (NLH, FNB)
                    VDK = (JXQ, VSB)
                    VBG = (MGC, CPF)
                    GVD = (VHX, TKT)
                    RKF = (MGC, CPF)
                    NHH = (LNS, TJX)
                    BKV = (CJV, MTV)
                    BBR = (BKX, SPS)
                    HJR = (NQB, BTJ)
                    CMF = (VRM, BHR)
                    TCN = (SJF, RPS)
                    JHP = (NVF, NXF)
                    KGH = (DSQ, MKL)
                    PKH = (VRM, BHR)
                    NVJ = (VNL, TXR)
                    LPL = (XCX, RDK)
                    MLF = (MML, JHQ)
                    JLP = (CFH, PXP)
                    NPS = (TNK, NVJ)
                    GJB = (NMD, RQF)
                    VRM = (HKL, KQQ)
                    BSV = (HMK, GQT)
                    RTJ = (QNH, THK)
                    KSF = (GKN, RRD)
                    VGH = (GQL, CHN)
                    MNM = (HVP, MXN)
                    GQL = (BMD, DQS)
                    JCM = (JGT, QGD)
                    DXN = (GKG, GQV)
                    GVV = (BTJ, NQB)
                    SHB = (SSM, PLS)
                    NXG = (NCK, LMV)
                    KQP = (FGC, LRP)
                    KDK = (QRS, LQC)
                    SNR = (XCX, RDK)
                    MHK = (BDJ, BDJ)
                    KQS = (FQC, GNQ)
                    SSM = (TFK, BKJ)
                    VDC = (MVN, LXL)
                    CML = (XMX, CXL)
                    HSG = (DLD, FMG)
                    MDL = (QCR, DSS)
                    CRC = (FBS, PMM)
                    GRF = (JKN, GJJ)
                    HKS = (JJP, QXP)
                    JGK = (QFK, XCG)
                    GQS = (GBJ, TPZ)
                    GPV = (XTJ, CNN)
                    VBP = (HPX, MMM)
                    CXL = (KKJ, CLH)
                    RVL = (DJC, LQT)
                    GJJ = (DXV, NTQ)
                    TGM = (KGR, TXH)
                    SGJ = (LDX, XTS)
                    CLP = (XBQ, MTD)
                    HGP = (FHP, RSF)
                    GMX = (NRP, GJX)
                    XBQ = (JTF, SHN)
                    NLQ = (KRB, HNQ)
                    HPX = (SKJ, RGC)
                    KFP = (QNP, LMT)
                    JHQ = (VMN, GQP)
                    LBL = (MPV, SMP)
                    DKF = (SKP, FJR)
                    CXM = (PHR, TVJ)
                    RMJ = (MMM, HPX)
                    XPK = (PFS, JCM)
                    DGM = (JCX, VMG)
                    BDJ = (DHV, DHV)
                    TDH = (BBM, XMT)
                    LTD = (QHX, MQS)
                    MNL = (JDH, DQH)
                    XTF = (PJD, LNJ)
                    FQC = (MCG, LKM)
                    QPV = (FDS, XGG)
                    LPQ = (QCV, KGG)
                    DXL = (TDB, SHX)
                    JNK = (SHB, VMX)
                    NNS = (XXH, HCB)
                    BCB = (XJG, LTD)
                    CPT = (CXL, XMX)
                    BKJ = (QLB, DDM)
                    PPD = (CXV, XDJ)
                    FKN = (RTJ, XQL)
                    MML = (VMN, GQP)
                    BJJ = (DQD, TMJ)
                    QSN = (MHT, QBD)
                    TKT = (TXM, PLN)
                    NTQ = (HJR, GVV)
                    MVK = (RVL, MNN)
                    NJQ = (LCP, CQK)
                    HTA = (NBK, SGP)
                    GCR = (RDB, CHV)
                    FHP = (LFN, GSX)
                    CFH = (SGJ, SXG)
                    VCK = (RLD, LXT)
                    FXL = (FDB, XFB)
                    KRB = (GPC, GPC)
                    JMV = (BLP, TGK)
                    LVF = (TRR, PCJ)
                    QRN = (DPK, MMX)
                    BNJ = (GLC, RSL)
                    XFL = (PCJ, TRR)
                    PCC = (GLV, NHG)
                    FJT = (HQB, DPR)
                    XPQ = (FKV, MVK)
                    KLQ = (XTG, XMS)
                    KGG = (PFJ, NPS)
                    TRR = (DVM, PCV)
                    QTR = (JHP, XXB)
                    DLD = (RDV, XCM)
                    FJS = (PFS, JCM)
                    SRC = (JSQ, BML)
                    LFH = (PCC, DFM)
                    XHS = (TMG, GPV)
                    JLV = (SQG, QPG)
                    DJC = (NSK, XBG)
                    JDH = (FSN, FSN)
                    SJM = (XPL, BVT)
                    JQT = (XPK, FJS)
                    SRD = (CLP, QJR)
                    PLN = (GDV, MFR)
                    MFR = (MXF, TRP)
                    NRP = (JLG, FSV)
                    XMT = (QGJ, LJL)
                    FVR = (XQN, DCR)
                    BDL = (PGL, LRK)
                    MSP = (PMS, JMM)
                    QVX = (KRM, NCN)
                    KVB = (DFV, VSF)
                    MNN = (LQT, DJC)
                    TNK = (TXR, VNL)
                    DVX = (BTD, XKG)
                    DFV = (HVR, FVG)
                    NCN = (DML, KXV)
                    PFS = (QGD, JGT)
                    LXV = (JGK, PTP)
                    FNB = (XKX, BJJ)
                    CSV = (CVV, KSF)
                    NSK = (GFC, BSV)
                    DMF = (DKF, DKF)
                    VJM = (BML, JSQ)
                    SMT = (FGC, LRP)
                    LKF = (SFB, HSG)
                    VPL = (GKH, GKH)
                    LPF = (NJH, JGN)
                    RNR = (NHK, SLB)
                    PQR = (QXC, FVR)
                    LDX = (NXG, CQC)
                    LPP = (GLC, RSL)
                    PLS = (TFK, BKJ)
                    BGF = (TLB, FRQ)
                    VGJ = (LQS, CKR)
                    NXM = (TRN, QFJ)
                    LMT = (FVQ, SRQ)
                    XBG = (GFC, BSV)
                    RVJ = (QXC, FVR)
                    LTQ = (PCC, DFM)
                    HQP = (TKT, VHX)
                    MJL = (BKX, SPS)
                    LQC = (SKG, HXH)
                    FVG = (JXK, SMH)
                    KKG = (XHS, VHF)
                    XGN = (QLG, BCB)
                    RRD = (FNM, QNR)
                    KLF = (NSJ, JLP)
                    PNT = (FBS, PMM)
                    CSK = (VBV, KHL)
                    GXF = (QBL, DPD)
                    FKD = (DKT, NDX)
                    MFF = (PMX, RDP)
                    VHF = (GPV, TMG)
                    TMJ = (KFP, VQM)
                    KCD = (KKG, FND)
                    CQK = (QQB, NTB)
                    NQT = (LQS, CKR)
                    FSR = (MHK, MHK)
                    CLD = (PXM, DBS)
                    NGJ = (VRJ, TRB)
                    QXC = (DCR, XQN)
                    RHR = (FJN, DKQ)
                    NVS = (CNJ, XNS)
                    VJK = (JQF, JLJ)
                    LKM = (CLG, JQQ)
                    BLP = (NNS, KVD)
                    FFF = (HQX, GDS)
                    XFB = (SCB, VHK)
                    XGG = (MPB, PNG)
                    SLQ = (CFJ, PKC)
                    SXG = (XTS, LDX)
                    CNC = (LCP, CQK)
                    PVZ = (TTL, SXT)
                    GGL = (MJD, BXG)
                    DPD = (RBJ, PKT)
                    SLM = (VPL, FNC)
                    NTV = (QCL, KDK)
                    DVD = (PMS, JMM)
                    QVL = (QTK, JLV)
                    THB = (PTP, JGK)
                    NTL = (KJC, NGJ)
                    VKS = (GHV, JBR)
                    QRS = (HXH, SKG)
                    JKN = (DXV, NTQ)
                    BHM = (KCD, LPC)
                    CHN = (DQS, BMD)
                    PXL = (SVN, KVJ)
                    CPX = (LVF, XFL)
                    LXR = (PQC, XVR)
                    FKX = (MXN, HVP)
                    DSV = (DTV, JXR)
                    CVV = (RRD, GKN)
                    JMM = (XPQ, DFD)
                    RSL = (NBN, VJK)
                    LJA = (LQV, HGB)
                    KMF = (SHQ, TKG)
                    JNH = (BGF, NBD)
                    XSS = (LNJ, PJD)
                    BCC = (GKP, XSB)
                    JTK = (GDS, HQX)
                    RQF = (XTF, XSS)
                    BXP = (MKL, DSQ)
                    ZZZ = (QGQ, LBL)
                    TFK = (QLB, QLB)
                    GKH = (LBL, QGQ)
                    JLJ = (QQT, CLD)
                    CRJ = (VPL, VPL)
                    TDL = (PHG, JNK)
                    QXX = (CPT, CML)
                    DKT = (QTR, NBQ)
                    FKV = (RVL, MNN)
                    GFC = (HMK, GQT)
                    LRK = (DKH, JCK)
                    QJR = (XBQ, MTD)
                    CFJ = (SMT, KQP)
                    TLB = (QRV, KLQ)
                    BJL = (JDG, DKG)
                    GTX = (SNR, LPL)
                    TBS = (CSX, DGM)
                    JGT = (KXJ, FXK)
                    MQS = (BRD, DHR)
                    CXK = (JJP, QXP)
                    PMS = (DFD, XPQ)
                    FJN = (NNR, NTL)
                    SRQ = (JQT, DFN)
                    KQN = (DSV, GKF)
                    GSK = (PHG, JNK)
                    PJD = (STT, FXL)
                    MKD = (DGM, CSX)
                    SGP = (GMR, NXJ)
                    DFN = (XPK, FJS)
                    STT = (XFB, FDB)
                    XXA = (SXT, TTL)
                    VDF = (JFK, NSS)
                    BKR = (HBC, GSC)
                    JKK = (CFJ, PKC)
                    TDB = (VDF, RFP)
                    QTK = (QPG, SQG)
                    LMV = (PPH, MXL)
                    XHN = (MJX, DXL)
                    QHX = (DHR, BRD)
                    VQM = (LMT, QNP)
                    XDM = (PKH, CMF)
                    VPP = (BBM, XMT)
                    DXV = (HJR, GVV)
                    HVP = (RMJ, VBP)
                    DPX = (JJR, XVJ)
                    DHV = (SXT, TTL)
                    NXJ = (JTK, FFF)""";
}
