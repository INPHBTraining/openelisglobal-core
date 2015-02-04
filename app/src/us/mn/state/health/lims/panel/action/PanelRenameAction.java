/**
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * 
* Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 * 
* The Original Code is OpenELIS code.
 * 
* Copyright (C) INPHB. All Rights Reserved.
 */
package us.mn.state.health.lims.panel.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import us.mn.state.health.lims.common.action.BaseAction;
import us.mn.state.health.lims.common.services.DisplayListService;

public class PanelRenameAction extends BaseAction {

    @Override
    protected ActionForward performAction(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        //Get list of panels from DisplayListService and assign it to the corrects struts form member
        //This will only be one or two lines depending on how you do it
        PropertyUtils.setProperty( form, "panelList", DisplayListService.getList( DisplayListService.ListType.PANELS ) );

        return mapping.findForward(FWD_SUCCESS);
    }

    @Override
    protected String getPageTitleKey() {
        return "panel.add.title";

    }

    @Override
    protected String getPageSubtitleKey() {
        return "panel.edit.title";

    }

}
