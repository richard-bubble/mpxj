//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v1.0.3-b18-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.02.21 at 11:46:13 GMT 
//


package net.sf.mpxj.planner.schema.impl;

public class ResourceGroupsImpl implements net.sf.mpxj.planner.schema.ResourceGroups, com.sun.xml.bind.RIElement, com.sun.xml.bind.JAXBObject, net.sf.mpxj.planner.schema.impl.runtime.UnmarshallableObject, net.sf.mpxj.planner.schema.impl.runtime.XMLSerializable, net.sf.mpxj.planner.schema.impl.runtime.ValidatableObject
{

    protected java.lang.String _DefaultGroup;
    protected com.sun.xml.bind.util.ListImpl _Group;
    public final static java.lang.Class version = (net.sf.mpxj.planner.schema.impl.JAXBVersion.class);
    private static com.sun.msv.grammar.Grammar schemaFragment;

    private final static java.lang.Class PRIMARY_INTERFACE_CLASS() {
        return (net.sf.mpxj.planner.schema.ResourceGroups.class);
    }

    public java.lang.String ____jaxb_ri____getNamespaceURI() {
        return "";
    }

    public java.lang.String ____jaxb_ri____getLocalName() {
        return "resource-groups";
    }

    public java.lang.String getDefaultGroup() {
        return _DefaultGroup;
    }

    public void setDefaultGroup(java.lang.String value) {
        _DefaultGroup = value;
    }

    protected com.sun.xml.bind.util.ListImpl _getGroup() {
        if (_Group == null) {
            _Group = new com.sun.xml.bind.util.ListImpl(new java.util.ArrayList());
        }
        return _Group;
    }

    public java.util.List getGroup() {
        return _getGroup();
    }

    public net.sf.mpxj.planner.schema.impl.runtime.UnmarshallingEventHandler createUnmarshaller(net.sf.mpxj.planner.schema.impl.runtime.UnmarshallingContext context) {
        return new net.sf.mpxj.planner.schema.impl.ResourceGroupsImpl.Unmarshaller(context);
    }

    public void serializeBody(net.sf.mpxj.planner.schema.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx2 = 0;
        final int len2 = ((_Group == null)? 0 :_Group.size());
        context.startElement("", "resource-groups");
        int idx_0 = idx2;
        while (idx_0 != len2) {
            context.childAsURIs(((com.sun.xml.bind.JAXBObject) _Group.get(idx_0 ++)), "Group");
        }
        context.endNamespaceDecls();
        int idx_2 = idx2;
        if (_DefaultGroup!= null) {
            context.startAttribute("", "default_group");
            try {
                context.text(((java.lang.String) _DefaultGroup), "DefaultGroup");
            } catch (java.lang.Exception e) {
                net.sf.mpxj.planner.schema.impl.runtime.Util.handlePrintConversionException(this, e, context);
            }
            context.endAttribute();
        }
        while (idx_2 != len2) {
            context.childAsAttributes(((com.sun.xml.bind.JAXBObject) _Group.get(idx_2 ++)), "Group");
        }
        context.endAttributes();
        while (idx2 != len2) {
            context.childAsBody(((com.sun.xml.bind.JAXBObject) _Group.get(idx2 ++)), "Group");
        }
        context.endElement();
    }

    public void serializeAttributes(net.sf.mpxj.planner.schema.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx2 = 0;
        final int len2 = ((_Group == null)? 0 :_Group.size());
    }

    public void serializeURIs(net.sf.mpxj.planner.schema.impl.runtime.XMLSerializer context)
        throws org.xml.sax.SAXException
    {
        int idx2 = 0;
        final int len2 = ((_Group == null)? 0 :_Group.size());
    }

    public java.lang.Class getPrimaryInterface() {
        return (net.sf.mpxj.planner.schema.ResourceGroups.class);
    }

    public com.sun.msv.verifier.DocumentDeclaration createRawValidator() {
        if (schemaFragment == null) {
            schemaFragment = com.sun.xml.bind.validator.SchemaDeserializer.deserialize((
 "\u00ac\u00ed\u0000\u0005sr\u0000\'com.sun.msv.grammar.trex.ElementPattern\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000"
+"\tnameClasst\u0000\u001fLcom/sun/msv/grammar/NameClass;xr\u0000\u001ecom.sun.msv."
+"grammar.ElementExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002Z\u0000\u001aignoreUndeclaredAttributesL\u0000"
+"\fcontentModelt\u0000 Lcom/sun/msv/grammar/Expression;xr\u0000\u001ecom.sun."
+"msv.grammar.Expression\u00f8\u0018\u0082\u00e8N5~O\u0002\u0000\u0002L\u0000\u0013epsilonReducibilityt\u0000\u0013Lj"
+"ava/lang/Boolean;L\u0000\u000bexpandedExpq\u0000~\u0000\u0003xppp\u0000sr\u0000\u001fcom.sun.msv.gra"
+"mmar.SequenceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001dcom.sun.msv.grammar.BinaryExp"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0004exp1q\u0000~\u0000\u0003L\u0000\u0004exp2q\u0000~\u0000\u0003xq\u0000~\u0000\u0004ppsr\u0000\u001dcom.sun.msv.g"
+"rammar.ChoiceExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\bppsr\u0000 com.sun.msv.grammar.A"
+"ttributeExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\u0003expq\u0000~\u0000\u0003L\u0000\tnameClassq\u0000~\u0000\u0001xq\u0000~\u0000\u0004sr\u0000\u0011"
+"java.lang.Boolean\u00cd r\u0080\u00d5\u009c\u00fa\u00ee\u0002\u0000\u0001Z\u0000\u0005valuexp\u0000psr\u0000\u001bcom.sun.msv.gram"
+"mar.DataExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\u0002dtt\u0000\u001fLorg/relaxng/datatype/Datatype"
+";L\u0000\u0006exceptq\u0000~\u0000\u0003L\u0000\u0004namet\u0000\u001dLcom/sun/msv/util/StringPair;xq\u0000~\u0000\u0004"
+"ppsr\u0000-com.sun.msv.datatype.xsd.NormalizedStringType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002"
+"\u0000\u0000xr\u0000#com.sun.msv.datatype.xsd.StringType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001Z\u0000\risAlw"
+"aysValidxr\u0000*com.sun.msv.datatype.xsd.BuiltinAtomicType\u0000\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0001\u0002\u0000\u0000xr\u0000%com.sun.msv.datatype.xsd.ConcreteType\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000"
+"\'com.sun.msv.datatype.xsd.XSDatatypeImpl\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0003L\u0000\fnamesp"
+"aceUrit\u0000\u0012Ljava/lang/String;L\u0000\btypeNameq\u0000~\u0000\u0019L\u0000\nwhiteSpacet\u0000.L"
+"com/sun/msv/datatype/xsd/WhiteSpaceProcessor;xpt\u0000 http://www"
+".w3.org/2001/XMLSchemat\u0000\u0010normalizedStringsr\u00004com.sun.msv.dat"
+"atype.xsd.WhiteSpaceProcessor$Replace\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000,com.sun."
+"msv.datatype.xsd.WhiteSpaceProcessor\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xp\u0001sr\u00000com.su"
+"n.msv.grammar.Expression$NullSetExpression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0004p"
+"psr\u0000\u001bcom.sun.msv.util.StringPair\u00d0t\u001ejB\u008f\u008d\u00a0\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0019"
+"L\u0000\fnamespaceURIq\u0000~\u0000\u0019xpt\u0000\u0005CDATAt\u0000\u0000sr\u0000#com.sun.msv.grammar.Sim"
+"pleNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0002L\u0000\tlocalNameq\u0000~\u0000\u0019L\u0000\fnamespaceURIq\u0000~\u0000\u0019"
+"xr\u0000\u001dcom.sun.msv.grammar.NameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xpt\u0000\rdefault_gro"
+"upq\u0000~\u0000&sr\u00000com.sun.msv.grammar.Expression$EpsilonExpression\u0000"
+"\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0004sq\u0000~\u0000\u000e\u0001q\u0000~\u0000,sq\u0000~\u0000\nppsr\u0000 com.sun.msv.grammar."
+"OneOrMoreExp\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xr\u0000\u001ccom.sun.msv.grammar.UnaryExp\u0000\u0000\u0000\u0000\u0000"
+"\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\u0003expq\u0000~\u0000\u0003xq\u0000~\u0000\u0004q\u0000~\u0000\u000fpsq\u0000~\u0000\u0000q\u0000~\u0000\u000fp\u0000sq\u0000~\u0000\nppsq\u0000~\u0000/q\u0000~\u0000"
+"\u000fpsq\u0000~\u0000\fq\u0000~\u0000\u000fpsr\u00002com.sun.msv.grammar.Expression$AnyStringEx"
+"pression\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000\u0004q\u0000~\u0000-q\u0000~\u00007sr\u0000 com.sun.msv.grammar.A"
+"nyNameClass\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0000xq\u0000~\u0000(q\u0000~\u0000,sq\u0000~\u0000\'t\u0000 net.sf.mpxj.planne"
+"r.schema.Groupt\u0000+http://java.sun.com/jaxb/xjc/dummy-elements"
+"q\u0000~\u0000,sq\u0000~\u0000\'t\u0000\u000fresource-groupsq\u0000~\u0000&sr\u0000\"com.sun.msv.grammar.Ex"
+"pressionPool\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001\u0002\u0000\u0001L\u0000\bexpTablet\u0000/Lcom/sun/msv/grammar/Ex"
+"pressionPool$ClosedHash;xpsr\u0000-com.sun.msv.grammar.Expression"
+"Pool$ClosedHash\u00d7j\u00d0N\u00ef\u00e8\u00ed\u001c\u0003\u0000\u0003I\u0000\u0005countB\u0000\rstreamVersionL\u0000\u0006parentt"
+"\u0000$Lcom/sun/msv/grammar/ExpressionPool;xp\u0000\u0000\u0000\u0006\u0001pq\u0000~\u0000\u000bq\u0000~\u0000.q\u0000~\u0000"
+"1q\u0000~\u00003q\u0000~\u00004q\u0000~\u0000\tx"));
        }
        return new com.sun.msv.verifier.regexp.REDocumentDeclaration(schemaFragment);
    }

    public class Unmarshaller
        extends net.sf.mpxj.planner.schema.impl.runtime.AbstractUnmarshallingEventHandlerImpl
    {


        public Unmarshaller(net.sf.mpxj.planner.schema.impl.runtime.UnmarshallingContext context) {
            super(context, "-------");
        }

        protected Unmarshaller(net.sf.mpxj.planner.schema.impl.runtime.UnmarshallingContext context, int startState) {
            this(context);
            state = startState;
        }

        public java.lang.Object owner() {
            return net.sf.mpxj.planner.schema.impl.ResourceGroupsImpl.this;
        }

        public void enterElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname, org.xml.sax.Attributes __atts)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  4 :
                        if (("group" == ___local)&&("" == ___uri)) {
                            _getGroup().add(((net.sf.mpxj.planner.schema.impl.GroupImpl) spawnChildFromEnterElement((net.sf.mpxj.planner.schema.impl.GroupImpl.class), 5, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        state = 5;
                        continue outer;
                    case  0 :
                        if (("resource-groups" == ___local)&&("" == ___uri)) {
                            context.pushAttributes(__atts, false);
                            state = 1;
                            return ;
                        }
                        break;
                    case  6 :
                        revertToParentFromEnterElement(___uri, ___local, ___qname, __atts);
                        return ;
                    case  5 :
                        if (("group" == ___local)&&("" == ___uri)) {
                            _getGroup().add(((net.sf.mpxj.planner.schema.impl.GroupImpl) spawnChildFromEnterElement((net.sf.mpxj.planner.schema.impl.GroupImpl.class), 5, ___uri, ___local, ___qname, __atts)));
                            return ;
                        }
                        break;
                    case  1 :
                        attIdx = context.getAttribute("", "default_group");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText1(v);
                            state = 4;
                            continue outer;
                        }
                        state = 4;
                        continue outer;
                }
                super.enterElement(___uri, ___local, ___qname, __atts);
                break;
            }
        }

        private void eatText1(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            try {
                _DefaultGroup = com.sun.xml.bind.WhiteSpaceProcessor.replace(value);
            } catch (java.lang.Exception e) {
                handleParseConversionException(e);
            }
        }

        public void leaveElement(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  4 :
                        state = 5;
                        continue outer;
                    case  6 :
                        revertToParentFromLeaveElement(___uri, ___local, ___qname);
                        return ;
                    case  5 :
                        if (("resource-groups" == ___local)&&("" == ___uri)) {
                            context.popAttributes();
                            state = 6;
                            return ;
                        }
                        break;
                    case  1 :
                        attIdx = context.getAttribute("", "default_group");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText1(v);
                            state = 4;
                            continue outer;
                        }
                        state = 4;
                        continue outer;
                }
                super.leaveElement(___uri, ___local, ___qname);
                break;
            }
        }

        public void enterAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  4 :
                        state = 5;
                        continue outer;
                    case  6 :
                        revertToParentFromEnterAttribute(___uri, ___local, ___qname);
                        return ;
                    case  1 :
                        if (("default_group" == ___local)&&("" == ___uri)) {
                            state = 2;
                            return ;
                        }
                        state = 4;
                        continue outer;
                }
                super.enterAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void leaveAttribute(java.lang.String ___uri, java.lang.String ___local, java.lang.String ___qname)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                switch (state) {
                    case  4 :
                        state = 5;
                        continue outer;
                    case  6 :
                        revertToParentFromLeaveAttribute(___uri, ___local, ___qname);
                        return ;
                    case  3 :
                        if (("default_group" == ___local)&&("" == ___uri)) {
                            state = 4;
                            return ;
                        }
                        break;
                    case  1 :
                        attIdx = context.getAttribute("", "default_group");
                        if (attIdx >= 0) {
                            final java.lang.String v = context.eatAttribute(attIdx);
                            eatText1(v);
                            state = 4;
                            continue outer;
                        }
                        state = 4;
                        continue outer;
                }
                super.leaveAttribute(___uri, ___local, ___qname);
                break;
            }
        }

        public void handleText(final java.lang.String value)
            throws org.xml.sax.SAXException
        {
            int attIdx;
            outer:
            while (true) {
                try {
                    switch (state) {
                        case  4 :
                            state = 5;
                            continue outer;
                        case  6 :
                            revertToParentFromText(value);
                            return ;
                        case  2 :
                            eatText1(value);
                            state = 3;
                            return ;
                        case  1 :
                            attIdx = context.getAttribute("", "default_group");
                            if (attIdx >= 0) {
                                final java.lang.String v = context.eatAttribute(attIdx);
                                eatText1(v);
                                state = 4;
                                continue outer;
                            }
                            state = 4;
                            continue outer;
                    }
                } catch (java.lang.RuntimeException e) {
                    handleUnexpectedTextException(value, e);
                }
                break;
            }
        }

    }

}