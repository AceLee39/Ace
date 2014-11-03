#直接法（Cuddington method）：
#	投资收益差额(S1) InvestmentIncomeDifferences S1
#   其它部门差额(S2) OtherSectorsDifferences S2
#   货币市场工具差额(S3) MoneyMarketInstrumentsDifferences S3
#   股本证券差额(S4) EquitySecuritiesDifferences S4
#   货币市场工具差额(S5) MoneyMarketInstrumentsDifferences S5
#

#Attribute
create table SOCF_ATTRIBUTE (
    id int promary key auto_increment,
    attr_key varchar(20) not null unique,
    attr_value varchar(20)
);

insert SOCF_ATTRIBUTE(id,attr_key,attr_value) values (null,'isInit','false') where not exist (select 1 from SOCF_ATTRIBUTE where attr_key='isInit');
insert SOCF_ATTRIBUTE(id,attr_key,attr_value) values (null,'version','v1') where not exist (select 1 from SOCF_ATTRIBUTE where attr_key='version');
update SOCF_ATTRIBUTE set attr_value = 'v1' where attr_key = 'version';
