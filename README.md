# TextFileReader
Read files from directory and search string in files &amp; insert into DB

Create table script:

create table nijat.mt102files (
refno varchar2(50),
filename varchar2(255),
indate date default trunc(sysdate)
);




