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
    <li>View struts-globalOpenELIS line 1611.  This will help you find the form bean, the action class and the jsp page</li>
    <li>Decide what information you will need for the form bean.  Part of it has been done for you</li>
    <li>Add the information in the action.  Look at other actions if you need to.  TestRenameAction.java would be a good one</li>
    <li>Add the needed elements to this page.  This will be most of the work
        <ol type="a">
            <li>Add collection iterator</li>
            <li>Add list of panels</li>
            <li>Add save button</li>
            <li></li>
        </ol>
    </li>
    <li>Find action that will be called when saved</li>
</ol>


