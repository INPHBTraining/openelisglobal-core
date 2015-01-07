<%@ page language="java"
         contentType="text/html; charset=utf-8"
         import="java.util.Date,
         us.mn.state.health.lims.common.action.IActionConstants" %>

<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/labdev-view" prefix="app" %>
<%@ taglib uri="/tags/sourceforge-ajax" prefix="ajax"%>


<div id="sound"></div>

<bean:define id="formName" value='<%= (String)request.getAttribute(IActionConstants.FORM_NAME) %>' />


<script language="JavaScript1.2">
    function savePage()
    {
        window.onbeforeunload = null; // Added to flag that formWarning alert isn't needed.
        var form = window.document.forms[0];
        form.action = "UpdatePanelRename.do";
        form.submit();

    }
</script>

<h2>Finishing story</h2>
<ol>
    <li>View "Web Pages/WEB-INF/struts-globalOpenELIS.xml" line 1611. This will be your starting point. 
        It will help you find the form bean, the action class, the tile definition and the jsp page.  
        These should be familiar terms</li>
    <li>Find the form bean and note the name of the property</li>
    <li>Find the name of the action and open it for editing</li>
    <li>Add the information in the action.  Look at other actions if you need to.  TestRenameAction.java would be a good one</li>
    <li>Add the needed elements to this jsp page.
        <ol type="a">
            <li>Add collection iterator</li>
            <li>Add list of panels in two columns, one with the original name, the other for editing.</li>
            <li>Add save button which will call the function "savePage"</li>
        </ol>
    </li>
    <li>Find the action that will be called when the panel renames are saved.  
        It can be found by understanding the form.action in the savePage function on this page</li>
    <li>In the same way you found the action for loading the page in struts-globalOpenELIS.xml you can find the same information
    for updating the page</li>
    <li>There are instructions in the update action java class to guide you</li>
    <li>When you are finished the updated panel name should be in the lefthand column of the reloaded page</li>
    <li>When you are satisfied everything is working, delete these instructions</li>
</ol>


