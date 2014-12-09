<!DOCTYPE html>
<html >
<head>
	<style type="text/css">
	</style>
	<script>dojoConfig = {parseOnLoad: true}</script>
	<script>
  /*   require(["dojo/parser", "dijit/layout/BorderContainer", "dijit/layout/ContentPane", "dojo/store/Memory", "dojo/query!css2",
             "dijit/Menu", "dijit/MenuItem", "dijit/tree/ObjectStoreModel", "dijit/Tree","dojo/dom",
             "dojo/domReady!"]);
     */
	</script>
</head>
<body class="claro">
    <div data-dojo-type="dijit/layout/BorderContainer" style="width: 100%; height: 100%;">
    <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'leading'" style="width: 20%">
    <div data-dojo-type="dojo/data/ItemFileReadStore" id="factoryTreeStore"
		data-dojo-id="fileTreeStore" style="display: none"
		data-dojo-props="url: '${base}/baseInformation/enterprise!getFactoryTree.action'"></div>
	<div data-dojo-type="dijit/tree/TreeStoreModel" id="factoryTreeModel"
		data-dojo-id="factoryTreeModel" style="display: none"
		data-dojo-props="store: fileTreeStore, query: {id: 'root'}"></div>
		
		
		<!-- Create the tree -->
		<div data-dojo-type="dijit/Tree" id="factoryTree"
			data-dojo-props="model: factoryTreeModel, openOnClick: true, showRoot: false"></div>
			
		<ul id="menuTree_menu" data-dojo-type="dijit/Menu"
		                    data-dojo-props='style:"display: none;", targetNodeIds: ["factoryTree"], selector: ".dijitTreeNode"'>
		            <li data-dojo-type="dijit/MenuItem">
		                    <script type="dojo/connect" data-dojo-event="onClick">
                           dom.byId("operation").innerHTML = "create";                        
  //var tn = dijit.byNode(this.getParent().currentTarget);
                          // alert(tn.item.id);
                    </script>
		                 create
		            </li>
		</ul>
		
    </div>
    <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'center'">center pane</div>
    <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'trailing'" style="width: 20%">Trailing pane</div>
</div>
</body>
</html>