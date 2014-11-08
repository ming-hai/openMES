<button type="button" data-dojo-type="dijit/form/Button" class="commandButton">
  <span>Factory Modeling</span>
	<script type="dojo/on" data-dojo-event="click">
		demo.addTab("mainTabContainer", "${base}/baseInformation/enterprise!index.action", "Factory Modeling", true);
	</script>
</button>
<button type="button" data-dojo-type="dijit/form/Button" class="commandButton">
  <span>Production Capability</span>
	<script type="dojo/on" data-dojo-event="click">
		demo.addTab("mainTabContainer", "basicForm.html", "Production Capability Modeling", true);
	</script>
</button>
<button type="button" data-dojo-type="dijit/form/Button" class="commandButton">
  <span>Material Management</span>
  <script type="dojo/on" data-dojo-event="click">
    demo.addTab("mainTabContainer", "moreForm.html", "Material Management", true);
  </script>
</button>
<button type="button" data-dojo-type="dijit/form/Button" class="commandButton">
  <span>Third-party System</span>
  <script type="dojo/on" data-dojo-event="click">
    demo.addTab("mainTabContainer", "moreForm.html", "Third-party System Management", true);
  </script>
</button>