
	<form name="FRM" accept-charset="UTF-8" method="post" action="andmetelisamine" class="lisa">
		<div>
			S�ndmuse nimi: <input id="nimi" value="" type="text" name="nimi" maxlength="50" /> <br /> 
			
			S�ndmuse t��p: <select id="t��p" name="tuup">
				<option value=""> </option>
				<option value="Arvutim�ng">Arvutim�ng</option>
				<option value="Lauam�ng">Lauam�ng</option>
			</select> <br /> 
			
			Kohtade arv: <input id="kohad" value="" type="text" name="kohad" maxlength="2"/> <br />
			
			Toimumise algus: <br />
			<div class="kuupaev_tavaline">
			<script type="text/javascript">fill_select(document.FRM);year_install(document.FRM);
			hour_install(document.FRM);minute_install(document.FRM)</script> <br />
			</div>
			
			Asula: <select name="asula">
				<option value=""> </option>
				<option value="Tallinn">Tallinn</option>
				<option value="Tartu">Tartu</option>
				<option value="P�rnu">P�rnu</option>
				<option value="Muu">Muu</option>
			</select> <br />
			 
			Aadress: <input id="aadress" value="" type="text" name="aadress" maxlength="100"/> 
			<br /> <input id="lisanupp" type="submit" value="Lisa s�ndmus" />
			
		</div>
	</form>
