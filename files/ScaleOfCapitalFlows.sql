#直接法（Cuddington method）：
#	投资收益差额(S1) InvestmentIncomeDifferences S1
#   其它部门差额(S2) OtherSectorsDifferences S2
#   货币市场工具差额(S3) MoneyMarketInstrumentsDifferences S3
#   股本证券差额(S4) EquitySecuritiesDifferences S4
#   货币市场工具差额(S5) MoneyMarketInstrumentsDifferences S5
#

create database DB_SOCF;#ScaleOfCapitalFlows 资本流动规模
use DB_SOCF;

create table SOCF_CUDDINGTON (
    ID int primary key auto_increment,
    NIAN_JD varchar(20) unique,
    is_nian_jd boolean,
    S1 double(30,4),
    S2 double(30,4),
    S3 double(30,4),
    S4 double(30,4),
    S5 double(30,4),
    S6 double(30,4),
    S7 double(30,4),
    S8 double(30,4),
    S9 double(30,4),
    S10 double(30,4),
    S11 double(30,4),
    S12 double(30,4),
    S13 double(30,4),
    S14 double(30,4),
    S15 double(30,4)
);

#间接法（Residual method）：

create table SOCF_RESIDUAL(
    ID int primary key auto_increment,
    NIAN_JD varchar(20) unique,
    S double(30,4),
    L1 double(30,4),
    L2 double(30,4),
    L3 double(30,4),
    L4 double(30,4),
    L5 double(30,4),
    L6 double(30,4),
    L7 double(30,4),
    L8 double(30,4),
    L9 double(30,4),
    L10 double(30,4),
    L11 double(30,4),
    L12 double(30,4),
    L13 double(30,4),
    L14 double(30,4),
    L15 double(30,4),
    L16 double(30,4),
    is_nian_jd boolean
);

#quarterScale
create table SOCF_QUARTER_SCALE (
    id int primary key auto_increment,
    nian_jd varchar(20) not null unique,
    residual varchar(20),
    cuddington varchar(20),
    is_nian_jd boolean
);




create table t_user(
    id int primary key auto_increment,
    username varchar(20) unique,
    password varchar(20)
);


create table SOCF_YD_RESIDUAL (
    id int primary key auto_increment,
    nian_yd varchar(20) not null unique,
    s double(30,4),
    fdi double(30,4),
    fbt double(30,4)
);

#MONTHSCALE
create table SOCF_MONTH_SCALE (
    id int primary key auto_increment,
    nian_yd varchar(20) not null unique,
    yd_residual varchar(20)
);


