
	<form name="FRM" accept-charset="UTF-8" method="post" action="minuservlet" class="lisa">
		<div>
			S�ndmuse nimi <input type="text" name="nimi" maxlength="50" /> <br /> 
			S�ndmuse t��p <select name="tuup">
				<option value="Arvutim�ng" selected="selected">Arvutim�ng</option>
				<option value="Lauam�ng">Lauam�ng</option>
			</select> <br /> 
			Kohtade arv <input type="text" name="kohad" maxlength="2"/> <br />
			Toimumise algus <br /> <script type="text/javascript">fill_select(document.FRM);year_install(document.FRM)</script> 
			Kell <input type="text" name="tund" size="1" maxlength="2"/> : <input type="text" name="minut" size="1" maxlength="2" /> 
			<br /> 
			Asula <select name="asula">
				<option value="Tartu">Tartu</option>
				<option value="Tallinn">Tallinn</option>
				<option value="P�rnu">P�rnu</option>
				<option value="Muu">Muu</option>
			</select> <br /> 
			Aadress <input type="text" name="aadress" maxlength="100"/> 
			<br /> <input id="lisanupp" type="submit" value="Lisa s�ndmus" />
		</div>
	</form>
