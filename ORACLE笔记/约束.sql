

alter table goods modify goodsName not null

ORA-01442: 要修改为 NOT NULL 的列已经是 NOT NULL


Table altered


alter table customer add addresscheck check(address in('东城','西城','朝阳','海淀','通州','崇文'))

ORA-02438: 列检查约束条件无法引用其他列

Name       Type          Nullable Default Comments 
---------- ------------- -------- ------- -------- 
CUSTOMERID CHAR(8)                                 
NAME       NVARCHAR2(50)                           
ADDRESS    NVARCHAR2(50) Y                         
EMAIL      VARCHAR2(50)  Y                         
SEX        CHAR(2)       Y        '男'             
CARDID     CHAR(18)      Y                         


Table altered

Name       Type          Nullable Default Comments 
---------- ------------- -------- ------- -------- 
CUSTOMERID CHAR(8)                                 
NAME       NVARCHAR2(50)                           
ADDRESS    NVARCHAR2(50) Y                         
EMAIL      VARCHAR2(50)  Y                         
SEX        CHAR(2)       Y        '男'             
CARDID     CHAR(18)      Y                         

Name       Type          Nullable Default Comments 
---------- ------------- -------- ------- -------- 
CUSTOMERID CHAR(8)                                 
NAME       NVARCHAR2(50)                           
ADDRESS    NVARCHAR2(50) Y                         
EMAIL      VARCHAR2(50)  Y                         
SEX        CHAR(2)       Y        '男'             
CARDID     CHAR(18)      Y                         


Commit complete

Name       Type          Nullable Default Comments 
---------- ------------- -------- ------- -------- 
CUSTOMERID CHAR(8)                                 
NAME       NVARCHAR2(50)                           
ADDRESS    NVARCHAR2(50) Y                         
EMAIL      VARCHAR2(50)  Y                         
SEX        CHAR(2)       Y        '男'             
CARDID     CHAR(18)      Y                         


CONSTRAINT_NAME                                                                  CONSTRAINT_TYPE STATUS   VALIDATED
-------------------------------------------------------------------------------- --------------- -------- -------------


CONSTRAINT_NAME                                                                  CONSTRAINT_TYPE STATUS   VALIDATED
-------------------------------------------------------------------------------- --------------- -------- -------------
SYS_C0010273                                                                     P               ENABLED  VALIDATED
SYS_C0010274                                                                     U               ENABLED  VALIDATED
CARDUNIQUE                                                                       U               ENABLED  VALIDATED
SYS_C0010271                                                                     C               ENABLED  VALIDATED
SYS_C0010272                                                                     C               ENABLED  VALIDATED
ADDRESSCHECK                                                                     C               ENABLED  VALIDATED

6 rows selected

Name                Type           Nullable Default Comments                                                                    
------------------- -------------- -------- ------- --------------------------------------------------------------------------- 
OWNER               VARCHAR2(128)  Y                Owner of the table                                                          
CONSTRAINT_NAME     VARCHAR2(128)  Y                Name associated with constraint definition                                  
CONSTRAINT_TYPE     VARCHAR2(1)    Y                Type of constraint definition                                               
TABLE_NAME          VARCHAR2(128)  Y                Name associated with table with constraint definition                       
SEARCH_CONDITION    LONG           Y                Text of search condition for table check                                    
SEARCH_CONDITION_VC VARCHAR2(4000) Y                Possibly truncated text of search condition for table check                 
R_OWNER             VARCHAR2(128)  Y                Owner of table used in referential constraint                               
R_CONSTRAINT_NAME   VARCHAR2(128)  Y                Name of unique constraint definition for referenced table                   
DELETE_RULE         VARCHAR2(9)    Y                The delete rule for a referential constraint                                
STATUS              VARCHAR2(8)    Y                Enforcement status of constraint -  ENABLED or DISABLED                     
DEFERRABLE          VARCHAR2(14)   Y                Is the constraint deferrable - DEFERRABLE or NOT DEFERRABLE                 
DEFERRED            VARCHAR2(9)    Y                Is the constraint deferred by default -  DEFERRED or IMMEDIATE              
VALIDATED           VARCHAR2(13)   Y                Was this constraint system validated? -  VALIDATED or NOT VALIDATED         
GENERATED           VARCHAR2(14)   Y                Was the constraint name system generated? -  GENERATED NAME or USER NAME    
BAD                 VARCHAR2(3)    Y                Creating this constraint should give ORA-02436.  Rewrite it before 2000 AD. 
RELY                VARCHAR2(4)    Y                If set, this flag will be used in optimizer                                 
LAST_CHANGE         DATE           Y                The date when this column was last enabled or disabled                      
INDEX_OWNER         VARCHAR2(128)  Y                The owner of the index used by the constraint                               
INDEX_NAME          VARCHAR2(128)  Y                The index used by the constraint                                            
INVALID             VARCHAR2(7)    Y                                                                                            
VIEW_RELATED        VARCHAR2(14)   Y                                                                                            
ORIGIN_CON_ID       NUMBER         Y                ID of Container where row originates                                        


Index created

Name       Type          Nullable Default Comments 
---------- ------------- -------- ------- -------- 
CUSTOMERID CHAR(8)                                 
NAME       NVARCHAR2(50)                           
ADDRESS    NVARCHAR2(50) Y                         
EMAIL      VARCHAR2(50)  Y                         
SEX        CHAR(2)       Y        '男'             
CARDID     CHAR(18)      Y                         

