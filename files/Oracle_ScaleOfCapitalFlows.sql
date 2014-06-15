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
    ID int primary key,
    NIAN_JD varchar2(20) unique,
    S1 number(30,4),
    S2 number(30,4),
    S3 number(30,4),
    S4 number(30,4),
    S5 number(30,4),
    S6 number(30,4),
    S7 number(30,4),
    S8 number(30,4),
    S9 number(30,4),
    S10 number(30,4),
    S11 number(30,4),
    S12 number(30,4),
    S13 number(30,4),
    S14 number(30,4),
    S15 number(30,4)
);

create sequence SEQ_CUDDINGTON;


#间接法（Residual method）：

create table SOCF_RESIDUAL(
    ID int primary key,
    NIAN_JD varchar2(20) unique,
    S number(30,4),
    L1 number(30,4),
    L2 number(30,4),
    L3 number(30,4),
    L4 number(30,4),
    L5 number(30,4),
    L6 number(30,4),
    L7 number(30,4),
    L8 number(30,4),
    L9 number(30,4),
    L10 number(30,4),
    L11 number(30,4),
    L12 number(30,4),
    L13 number(30,4),
    L14 number(30,4),
    L15 number(30,4),
    L16 number(30,4)
);

create sequence SEQ_RESIDUAL;

#quarterScale
create table SOCF_QUARTER_SCALE (
    id int primary key,
    nian_jd varchar2(20) not null unique,
    residual varchar2(20),
    cuddington varchar2(20)
);

create sequence SEQ_QUARTER_SCALE;

create table t_user(
    id int primary key,
    username varchar2(20) unique,
    password varchar2(20)
);


create table SOCF_YD_RESIDUAL (
    id int primary key,
    nian_yd varchar2(20) not null unique,
    s number(30,4),
    fdi number(30,4),
    fbt number(30,4)
);

create sequence SEQ_YD_RESIDUAL;

#MONTHSCALE
create table SOCF_MONTH_SCALE (
    id int primary key,
    nian_yd varchar2(20) not null unique,
    ydResidual varchar2(20)
);
create sequence SEQ_MONTH_SCALE;


