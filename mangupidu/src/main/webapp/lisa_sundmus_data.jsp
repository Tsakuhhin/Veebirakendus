
	<form name="FRM" accept-charset="UTF-8" method="post" action="minuservlet" class="lisa">
		<div>
			S�ndmuse nimi <input id="nimi" value="" type="text" name="nimi" maxlength="50" /> <br /> 
			S�ndmuse t��p <select id="t��p" name="tuup">
				<option value="Arvutim�ng" selected="selected">Arvutim�ng</option>
				<option value="Lauam�ng">Lauam�ng</option>
			</select> <br /> 
			Kohtade arv <input id="kohad" value="" type="text" name="kohad" maxlength="2"/> <br />
			Toimumise algus <br /> <script type="text/javascript">fill_select(document.FRM);year_install(document.FRM)</script> 
			Kell <input id="tund" value="" type="text" name="tund" size="1" maxlength="2"/> : 
			<input id="tund" value="" type="text" name="minut" size="1" maxlength="2" /> 
			<br /> 
			Asula <select name="asula">
				<option value="Tartu" selected="selected">Tartu</option>
				<option value="Tallinn">Tallinn</option>
				<option value="P�rnu">P�rnu</option>
				<option value="Muu">Muu</option>
			</select> <br /> 
			Aadress <input id="aadress" value="" type="text" name="aadress" maxlength="100"/> 
			<br /> <input id="lisanupp" type="submit" value="Lisa s�ndmus" />
		</div>
	</form>
