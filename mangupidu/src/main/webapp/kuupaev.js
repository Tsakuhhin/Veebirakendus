var date_arr = new Array;
var days_arr = new Array;
var minutes_arr = new Array;

date_arr[0]=new Option("jaanuar",01);
date_arr[1]=new Option("veebruar",02);
date_arr[2]=new Option("märts",03);
date_arr[3]=new Option("aprill",04);
date_arr[4]=new Option("mai",05);
date_arr[5]=new Option("juuni",06);
date_arr[6]=new Option("juuli",07);
date_arr[7]=new Option("august",08);
date_arr[8]=new Option("september",09);
date_arr[9]=new Option("oktoober",10);
date_arr[10]=new Option("november",11);
date_arr[11]=new Option("detsember",12);

minutes_arr[0]=new Option(00);
minutes_arr[1]=new Option(15);
minutes_arr[2]=new Option(30);
minutes_arr[3]=new Option(45);

function fill_select(f)
{
        document.writeln("kuu <SELECT name=\"months\" onchange=\"update_days(FRM)\">");
        for(x=0;x<12;x++)
        document.writeln("<OPTION value=\""+date_arr[x].value+"\">"+date_arr[x].text);
        document.writeln("</SELECT> päev <SELECT name=\"days\"></SELECT>");
        selection=f.months[f.months.selectedIndex].value;
}

function update_days(f)
{
        temp=f.days.selectedIndex;
        for(x=days_arr.length;x>0;x--)
        {
                days_arr[x]=null;
                f.days.options[x]=null;
        }
        selection=parseInt(f.months[f.months.selectedIndex].value);
        if (f.months[f.months.selectedIndex].value == 01 || f.months[f.months.selectedIndex].value == 03 || 
        		f.months[f.months.selectedIndex].value == 05 || f.months[f.months.selectedIndex].value == 07 || 
        		f.months[f.months.selectedIndex].value == 08 || f.months[f.months.selectedIndex].value == 10 || 
        		f.months[f.months.selectedIndex].value == 12)
        	selection = 31;
        else 
        {
        	if (f.months[f.months.selectedIndex].value == 02)
        		selection = 28;
        	else
        		selection = 30;
        }
        
        
        ret_val = 0;
        if(f.months[f.months.selectedIndex].value == 02)
        {
                year=parseInt(f.years.options[f.years.selectedIndex].value);
                if (year % 4 != 0 || year % 100 == 0 ) ret_val=0;
                else
                        if (year % 400 == 0)  ret_val=1;
                        else
                                ret_val=1;
        }
        selection = selection + ret_val;
        for(x=1;x < selection+1;x++)

        {
                days_arr[x-1]=new Option(x);
                f.days.options[x-1]=days_arr[x-1];
        }
        if (temp == -1) f.days.options[0].selected=true;
        else
             f.days.options[temp].selected=true;
}
function year_install(f)
{
        document.writeln(" aasta <SELECT name=\"years\" onchange=\"update_days(FRM)\">");
        for(x=2014;x<2016;x++) document.writeln("<OPTION value=\""+x+"\">"+x);
        document.writeln("</SELECT>");
        update_days(f)
}

function hour_install(f)
{
        document.writeln(" kellaaeg <SELECT  name =\"hours\">");
        for(x=00;x<23;x++) document.writeln("<OPTION value=\""+x+"\">"+x);
        document.writeln("</SELECT>");
}

function minute_install(f)
{
	 document.writeln("<SELECT name=\"minutes\">");
     for(x=0;x<4;x++)
     document.writeln("<OPTION value=\""+"\">"+minutes_arr[x].text);
     document.writeln("</SELECT>");
}