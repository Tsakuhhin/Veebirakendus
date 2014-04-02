var date_arr = new Array;
var days_arr = new Array;

date_arr[0]=new Option(01,31);
date_arr[1]=new Option(02,28);
date_arr[2]=new Option(03,31);
date_arr[3]=new Option(04,30);
date_arr[4]=new Option(05,31);
date_arr[5]=new Option(06,30);
date_arr[6]=new Option(07,31);
date_arr[7]=new Option(08,30);
date_arr[8]=new Option(09,30);
date_arr[9]=new Option(10,31);
date_arr[10]=new Option(11,31);
date_arr[11]=new Option(12,30);

function fill_select(f)
{
        document.writeln("Kuu <SELECT name=\"months\"               onchange=\"update_days(FRM)\">");
        for(x=0;x<12;x++)
                document.writeln("<OPTION value=\""+date_arr[x].value+"\">"+date_arr[x].text);
        document.writeln("</SELECT> Päev <SELECT name=\"days\"></SELECT>");
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
        ret_val = 0;
        if(f.months[f.months.selectedIndex].value == 28)
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
        document.writeln(" Aasta <SELECT name=\"years\" onchange=\"update_days(FRM)\">")
        for(x=2014;x<2016;x++) document.writeln("<OPTION value=\""+x+"\">"+x);
        document.writeln("</SELECT>");
        update_days(f)
}
