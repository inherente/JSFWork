drop TABLE CC_COLUMN_REPORT_DESCRIPTION ;
CREATE TABLE CC_COLUMN_REPORT_DESCRIPTION 
(
    COLUMN_ID NUMBER NOT NULL 
    , report_ID NUMBER NOT NULL 
    , COLUMN_NAME VARCHAR2(1024) 
    , DISPLAY_NAME VARCHAR2(1024) 
    , STATUS VARCHAR2(32) 
    , COL_ALIGN VARCHAR2(1024) 
    , COL_TYPES VARCHAR2(1024) 
    , COL_SORTING VARCHAR2(1024) 
    , COL_WIDTH VARCHAR2(1024) 
    , ENABLETOOLTIPS VARCHAR2(1024) 
    , ATTACHHEADER VARCHAR2(1024) 
    , LAST_MODIFICATION_DATE DATE 
    , LAST_MODIFIED_BY VARCHAR2(1024) 
);
